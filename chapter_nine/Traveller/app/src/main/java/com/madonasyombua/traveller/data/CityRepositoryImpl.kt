package com.madonasyombua.traveller.data

import kotlinx.coroutines.flow.flow

class CityRepositoryImpl : CityRepository {

    override fun getCities() = flow {
        val cities = CityDataSource.loadCities
        emit(cities)
    }
}