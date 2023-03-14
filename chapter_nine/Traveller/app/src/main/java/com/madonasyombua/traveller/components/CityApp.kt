package com.madonasyombua.traveller.components

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.madonasyombua.traveller.CityViewModel
import com.madonasyombua.traveller.ui.theme.TravellerTheme
import com.madonasyombua.traveller.util.DevicePosture

@Composable
fun CityApp(
    windowSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    devicePosture: DevicePosture = DevicePosture.NormalPosture,
    cityViewModel: CityViewModel = viewModel()
) {
    val navController = rememberNavController()
    val contentType: ContentType
    val navigationType: CityNavigation
    when (windowSizeClass) {
        WindowWidthSizeClass.Compact -> {
            navigationType = CityNavigation.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = CityNavigation.NAVIGATION_RAIL
            contentType = if (devicePosture is DevicePosture.CityPosture
                || devicePosture is DevicePosture.Separating
            ) {
                ContentType.CITY_DETAIL
            } else {
                ContentType.LIST_ONLY
            }
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = if (devicePosture is DevicePosture.CityPosture) {
                CityNavigation.NAVIGATION_RAIL
            } else {
                CityNavigation.NAVIGATION_DRAWER
            }
            contentType = ContentType.CITY_DETAIL
        }
        else -> {
            navigationType = CityNavigation.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }
    }

    CityUi(
        contentType = contentType,
        navigationType = navigationType,
        navController = navController,
        cityViewModel = cityViewModel,
    )
}


@Preview(showBackground = true)
@Composable
fun CityPreview() {
    TravellerTheme {
        CityApp(
            windowSizeClass = WindowWidthSizeClass.Compact,
            devicePosture = DevicePosture.NormalPosture
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun CityPreviewTablet() {
    TravellerTheme {
        CityApp(
            devicePosture = DevicePosture.NormalPosture
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CityPreviewDesktop() {
    TravellerTheme {
        CityApp(
            windowSizeClass = WindowWidthSizeClass.Expanded,
            devicePosture = DevicePosture.NormalPosture
        )
    }
}