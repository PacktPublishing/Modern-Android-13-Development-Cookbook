package com.madonasyombua.traveller.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.madonasyombua.traveller.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    navController: NavController,
    modifier: Modifier = Modifier,
    selectedDestination: MutableState<String> = rememberSaveable { mutableStateOf(Screen.City.route) },
    onDrawerClicked: () -> Unit = {}
) {
    Column(
        modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(20.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name).uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            IconButton(onClick = onDrawerClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        }

        NavigationDrawerItem(
            selected = selectedDestination.value == Screen.City.route,
            label = {
                Text(
                    text = stringResource(id = R.string.city_list),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.city_list)
                )
            },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
            onClick = {
                selectedDestination.value = Screen.City.route
                navController.navigate(Screen.City.route) {
                    popUpTo(Screen.City.route) { inclusive = true }
                }
            }
        )

        NavigationDrawerItem(
            selected = selectedDestination.value == Screen.Profile.route,
            label = {
                Text(
                    text = stringResource(id = R.string.profile),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(id = R.string.profile)
                )
            },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
            onClick = {
                selectedDestination.value = Screen.Profile.route
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.City.route)
                }
            }
        )
    }
}
