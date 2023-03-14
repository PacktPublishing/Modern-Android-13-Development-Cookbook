package com.madonasyombua.traveller.components

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madonasyombua.traveller.CityViewModel

enum class ContentType {
    LIST_ONLY, CITY_DETAIL
}

@Composable
fun CityScreenDisplay(
    contentType: ContentType,
    onCitySelected: (index: Int) -> Unit,
    cityViewModel: CityViewModel = viewModel(),
    getCities: () -> Unit = { cityViewModel.getCities() },
) {
    val getAllCities by rememberUpdatedState(newValue = getCities)
    LaunchedEffect(true) {
        getAllCities()
    }

    val city = cityViewModel.city.collectAsState().value
    if (contentType == ContentType.CITY_DETAIL) {
       CityListDetailComposable(city)
    } else {
        CityListComposable(
            city = city,
            onItemSelected = onCitySelected,
        )
    }
}

