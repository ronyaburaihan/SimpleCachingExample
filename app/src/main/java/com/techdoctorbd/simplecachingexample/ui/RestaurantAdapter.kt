package com.techdoctorbd.simplecachingexample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techdoctorbd.simplecachingexample.databinding.RestaurantItemBinding
import com.techdoctorbd.simplecachingexample.data.Restaurant
import com.techdoctorbd.simplecachingexample.utils.RestaurantsDiffUtils

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private var restaurants = emptyList<Restaurant>()

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = restaurants[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    fun setData(newData: List<Restaurant>) {
        val recipesDiffUtils = RestaurantsDiffUtils(newData, restaurants)
        val diffUtils = DiffUtil.calculateDiff(recipesDiffUtils)
        restaurants = newData
        diffUtils.dispatchUpdatesTo(this)
    }
}
