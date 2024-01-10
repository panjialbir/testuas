package com.example.testuas.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testuas.data.OrderRoomDao

class OrderRoomViewModelFactory(private val orderRoomDao: OrderRoomDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderRoomViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OrderRoomViewModel(orderRoomDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}