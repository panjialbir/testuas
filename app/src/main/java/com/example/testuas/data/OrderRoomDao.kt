package com.example.testuas.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface OrderRoomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tambahPenyewaan(orderRoom: OrderRoom)


    @Update
    suspend fun update(orderRoom: OrderRoom)

    @Delete
    suspend fun delete(orderRoom: OrderRoom)

    @Query("SELECT * from penyewaan_karaoke WHERE id = :id")
    fun getOrder(id: Int): Flow<OrderRoom>

    @Query("SELECT * from penyewaan_karaoke ORDER BY namaPelanggan ASC")
    fun getAllOrder() : Flow<List<OrderRoom>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLC(lc: LC)

    @Query("SELECT * from table_lc ORDER BY lcname ASC") // Ganti someField dengan nama field yang sesuai di LC
    fun getAllLC(): Flow<List<LC>>

    // Fungsi tambahan untuk mendapatkan LC berdasarkan ID
    @Query("SELECT * from table_lc WHERE lcid = :id")
    fun getLC(id: Int): Flow<LC>

}

