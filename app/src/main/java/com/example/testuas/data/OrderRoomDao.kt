package com.example.testuas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface OrderRoomDao {
    @Insert
    suspend fun tambahPenyewaan(penyewaan: OrderRoom)
    suspend fun insertLC(lc: LC)

    @Query("SELECT * FROM penyewaan_karaoke")
    suspend fun semuaPenyewaan(): List<OrderRoom>
    fun insertOrder(order: OrderRoom)
    fun getAllOrders():  List<OrderRoom>
    suspend fun getAllLC(): List<LC>

}

