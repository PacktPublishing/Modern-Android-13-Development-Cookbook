package com.madonasyombua.composebasics.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madonasyombua.composebasics.favoritecity.City
import com.madonasyombua.composebasics.favoritecity.CityDataSource

@Composable
fun CityApp() {
    CityList(cityList = CityDataSource().loadCities())
}

@Composable
fun CityList(cityList: List<City>) {
    LazyColumn {
        items(cityList) { cities ->
            CityCard(cities)
        }
    }
}

@Composable
fun CityCard(city: City) {
    Card(modifier = Modifier.padding(10.dp), elevation = 4.dp) {
        Column {
            Image(
                painter = painterResource(city.imageResourceId),
                contentDescription = stringResource(city.nameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(154.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(city.nameResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityCardPreview() {
    CityApp()
}