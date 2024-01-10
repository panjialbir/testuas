package com.example.testuas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.reflect.KClass

@Database(entities = [OrderRoom::class], version = 1, exportSchema = false)
abstract class Database(version: Int, exportSchema: Boolean, entities: Array<KClass<OrderRoom>>) : RoomDatabase() {
    abstract fun OrderRoomDao(): OrderRoomDao
}