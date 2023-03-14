package com.madonasyombua.traveller.data

import com.madonasyombua.composebasics.favoritecity.City
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun getCities(): Flow<List<City>>
}

