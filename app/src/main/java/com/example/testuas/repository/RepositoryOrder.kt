package com.example.testuas.repository

import com.example.testuas.data.OrderRoom
import kotlinx.coroutines.flow.Flow

interface RepositoryOrder {
    fun getAllOrder(): Flow<List<OrderRoom>>

    fun getOrder(id: Int): Flow<OrderRoom>

    suspend fun insertOrder(orderRoom: OrderRoom)

    suspend fun deleteOrder(orderRoom: OrderRoom)

    suspend fun updateOrder(orderRoom: OrderRoom)
    fun getAllOrderStream(): Flow<List<OrderRoom>>
    fun getOrderStream(id: Int): Flow<OrderRoom?>
}