package com.techdoctorbd.simplecachingexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.techdoctorbd.simplecachingexample.databinding.ActivityMainBinding
import com.techdoctorbd.simplecachingexample.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            recyclerview.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        viewModel.restaurantsLiveData.observe(this, {
            restaurantAdapter.setData(it.data!!)

            binding.progressbar.isVisible = it is Resource.Loading && it.data.isNullOrEmpty()
        })
    }
}