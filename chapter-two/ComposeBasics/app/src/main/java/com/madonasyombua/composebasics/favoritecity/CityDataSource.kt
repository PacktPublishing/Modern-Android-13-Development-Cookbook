package com.madonasyombua.composebasics.favoritecity

import com.madonasyombua.composebasics.R

class CityDataSource {
    fun loadCities(): List<City> {
        return listOf<City>(
            City(R.string.spain, R.drawable.spain),
            City(R.string.new_york, R.drawable.newyork),
            City(R.string.tokyo, R.drawable.tokyo),
            City(R.string.switzerland, R.drawable.switzerland),
            City(R.string.singapore, R.drawable.singapore),
            City(R.string.paris, R.drawable.paris),
        )
    }
}