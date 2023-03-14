package com.madonasyombua.traveller.components

enum class CityNavigation {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, NAVIGATION_DRAWER
}

sealed class Screen(val route: String) {
    object City : Screen("city")
    object CityDetail : Screen("city/{cityIndex}") {
        fun createRoute(cityIndex: Int) = "city/$cityIndex"
    }
    object Profile : Screen("profile")
}

