package com.techdoctorbd.simplecachingexample.utils

import androidx.recyclerview.widget.DiffUtil
import com.techdoctorbd.simplecachingexample.data.Restaurant

class RestaurantsDiffUtils(
    private val newList: List<Restaurant>,
    private val oldList: List<Restaurant>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}