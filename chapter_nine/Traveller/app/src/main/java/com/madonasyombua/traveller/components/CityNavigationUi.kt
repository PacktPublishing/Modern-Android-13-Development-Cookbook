package com.madonasyombua.traveller.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.madonasyombua.traveller.CityViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityUi(
    modifier: Modifier = Modifier,
    contentType: ContentType = ContentType.LIST_ONLY,
    navigationType: CityNavigation = CityNavigation.BOTTOM_NAVIGATION,
    navController: NavHostController = rememberNavController(),
    cityViewModel: CityViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    if (navigationType == CityNavigation.NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(drawerContent = {
            NavigationDrawer(
                navController = navController
            )
        }) {
            CityAppContent(
                navigationType = navigationType,
                contentType = contentType,
                modifier = modifier,
                navController = navController,
                cityViewModel = cityViewModel
            )
        }
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawer(
                    navController = navController,
                    onDrawerClicked = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            },
            drawerState = drawerState
        ) {
            CityAppContent(
                navigationType = navigationType,
                contentType = contentType,
                modifier = modifier,
                navController = navController,
                cityViewModel = cityViewModel,
                onDrawerClicked = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    }
}
