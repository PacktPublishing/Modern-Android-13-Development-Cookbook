package com.madonasyombua.traveller.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.madonasyombua.composebasics.favoritecity.City
import com.madonasyombua.traveller.R

@Composable
fun CityListComposable(
    onItemSelected: (Int) -> Unit,
    city: List<City>,
    modifier: Modifier = Modifier,

    ) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        itemsIndexed(city) { index, city ->
            CityCard(
                modifier = modifier.clickable {
                    onItemSelected(index)
                },
                city = city,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityCard(modifier: Modifier, city: City) {
    Card(modifier = modifier.padding(10.dp), shape = RoundedCornerShape(8.dp)) {
        Column {
            Image(
                painter = painterResource(city.imageResourceId),
                contentDescription = stringResource(R.string.city_images),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(154.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(city.nameResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
