package com.techdoctorbd.simplecachingexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.techdoctorbd.simplecachingexample.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: RestaurantRepository) : ViewModel() {
    val restaurantsLiveData = repository.getRestaurants().asLiveData()

}