package com.madonasyombua.traveller.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.composebasics.favoritecity.City
import com.madonasyombua.traveller.R

@Composable
fun CityListDetailComposable(
    cities: List<City>,
    modifier: Modifier = Modifier,
    selectedIndex: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
) {
    Row(
        modifier = modifier,
    ) {
        CityListComposable(
            city = cities,
            modifier = modifier.weight(1f),
            onItemSelected = { index ->
                selectedIndex.value = index
            })
        if (cities.isNotEmpty()) {
            val city = cities[selectedIndex.value]
            CityDetailComposable(modifier = modifier.weight(1f), city = city)
        }
    }
}

@Composable
fun CityDetailComposable(
    modifier: Modifier = Modifier,
    city: City = City(R.string.spain, R.drawable.spain)
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = city.nameResourceId),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}