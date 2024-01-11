package com.example.testuas.ui.theme

import android.app.Application
import com.example.testuas.data.DatabaseOrder
import com.example.testuas.repository.OfflineRepositoryOrder

class AplikasiOrderRoom : Application() {

    lateinit var container: DependencyContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = DependencyContainer(this)
    }
}

class DependencyContainer(private val application: Application) {

    private val databaseOrder by lazy { DatabaseOrder.getDatabase(application) }
    val offlineRepositoryOrder by lazy { OfflineRepositoryOrder(databaseOrder.orderRoomDao()) }
}