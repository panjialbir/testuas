package com.example.testuas.model

import androidx.lifecycle.ViewModel
import com.example.testuas.data.LC
import com.example.testuas.data.OrderRoom
import com.example.testuas.data.OrderRoomDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderRoomViewModel(private val orderRoomDao: OrderRoomDao) : ViewModel() {

    // Implementasikan metode-metode ViewModel sesuai kebutuhan Anda

    suspend fun insertOrder(order: OrderRoom) {
        withContext(Dispatchers.IO) {
            orderRoomDao.insertOrder(order)
        }
    }

    suspend fun getAllOrders(): List<OrderRoom> {
        return withContext(Dispatchers.IO) {
            orderRoomDao.getAllOrders()
        }
    }

    suspend fun insertLC(lc: LC) {
        withContext(Dispatchers.IO) {
            orderRoomDao.insertLC(lc)
        }
    }

    suspend fun getAllLC(): List<LC> {
        return withContext(Dispatchers.IO) {
            orderRoomDao.getAllLC()
        }
    }

    // ... tambahkan metode lainnya sesuai kebutuhan
}