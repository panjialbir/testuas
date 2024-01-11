package com.example.testuas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.reflect.KClass

@Database(entities = [OrderRoom::class], version = 1, exportSchema = false)

abstract class DatabaseOrder : RoomDatabase() {
    abstract fun orderRoomDao() : OrderRoomDao

    companion object {
        @Volatile
        private var Instance: DatabaseOrder? = null

        fun getDatabase(context: Context): DatabaseOrder {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DatabaseOrder::class.java, "order_database").build()
                    .also { Instance = it }
            })
        }
    }
}