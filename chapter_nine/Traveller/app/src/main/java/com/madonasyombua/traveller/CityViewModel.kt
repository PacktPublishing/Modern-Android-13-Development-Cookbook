package com.madonasyombua.traveller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.traveller.data.City
import com.madonasyombua.traveller.data.CityRepository
import com.madonasyombua.traveller.data.CityRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityViewModel(
    private val repository: CityRepository = CityRepositoryImpl()
) : ViewModel() {

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val city: StateFlow<List<City>>
        get() = _cities

    fun getCities() {
        viewModelScope.launch {
            val result = repository.getCities()
            result.collect {cityList ->
                _cities.value = cityList
            }
        }
    }
}