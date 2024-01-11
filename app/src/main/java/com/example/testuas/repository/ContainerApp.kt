package com.example.testuas.repository

import android.content.Context
import androidx.room.Database
import com.example.testuas.data.DatabaseOrder

interface ContainerApp{
    val repositoryOrder : RepositoryOrder
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoryOrder: RepositoryOrder by lazy {
        OfflineRepositoryOrder(DatabaseOrder.getDatabase(context).orderRoomDao())
    }
}