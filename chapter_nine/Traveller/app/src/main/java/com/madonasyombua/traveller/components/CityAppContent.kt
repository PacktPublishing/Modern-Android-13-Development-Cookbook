package com.madonasyombua.traveller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.madonasyombua.composebasics.favoritecity.City
import com.madonasyombua.traveller.CityViewModel
import com.madonasyombua.traveller.R

@Composable
fun CityAppContent(
    navigationType: CityNavigation,
    contentType: ContentType,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    cityViewModel: CityViewModel = viewModel(),
    onDrawerClicked: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(visible = navigationType == CityNavigation.NAVIGATION_RAIL) {
                CityNavigationRail(
                    onDrawerClicked = onDrawerClicked,
                    navController = navController
                )
            }
            Column(
                modifier = modifier.fillMaxSize()
            ) {
                CityNavHost(
                    modifier = modifier.weight(1f),
                    contentType = contentType,
                    navController = navController,
                    cityViewModel = cityViewModel
                )
                AnimatedVisibility(visible = navigationType == CityNavigation.BOTTOM_NAVIGATION) {
                    CityBottomNavigationBar(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CityBottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.City.route } == true,
            onClick = {
                navController.navigate(Screen.City.route) {
                    popUpTo(Screen.City.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.cityList)
                )
            }
        )

        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.City.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = stringResource(id = R.string.profile)
                )
            }
        )
    }
}

@Composable
fun CityNavHost(
    modifier: Modifier,
    contentType: ContentType,
    navController: NavHostController,
    cityViewModel: CityViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.City.route,
        modifier = modifier
    ) {
        composable(Screen.City.route) {
            CityScreenDisplay(
                cityViewModel = cityViewModel,
                contentType = contentType,
                onCitySelected = { index ->
                    val route = Screen.CityDetail.createRoute(index)
                    navController.navigate(route)
                }
            )
        }
        composable(Screen.CityDetail.route) { backStackEntry ->
            val cityIndex =
                backStackEntry.arguments?.getString("cityIndex")?.toInt() ?: 0
            CityDetailScreen(
                cityViewModel = cityViewModel,
                cityIndex = cityIndex
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun CityDetailScreen(cityViewModel: CityViewModel = viewModel(), cityIndex: Int = 0) {
    val city: City = cityViewModel.city.collectAsState().value[cityIndex]
    CityDetailComposable(city = city)
}

@Composable
fun CityNavigationRail(
    onDrawerClicked: () -> Unit = {},
    selectedDestination: MutableState<String> = rememberSaveable { mutableStateOf(Screen.City.route) },
    navController: NavController = rememberNavController()
) {
    NavigationRail(modifier = Modifier.fillMaxHeight()) {
        NavigationRailItem(
            selected = false,
            onClick = onDrawerClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        )
        NavigationRailItem(
            selected = selectedDestination.value == Screen.City.route,
            onClick = {
                selectedDestination.value = Screen.City.route
                navController.navigate(Screen.City.route) {
                    popUpTo(Screen.City.route) { inclusive = true }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.cityList)
                )
            }
        )
        NavigationRailItem(
            selected = selectedDestination.value == Screen.Profile.route,
            onClick = {
                selectedDestination.value = Screen.Profile.route
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.City.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    stringResource(id = R.string.profile)
                )
            }
        )
    }
}
