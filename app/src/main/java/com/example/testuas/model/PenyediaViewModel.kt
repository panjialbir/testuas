package com.example.testuas.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.testuas.ui.theme.AplikasiOrderRoom

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }

        initializer {
            OrderRoomViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }

        initializer {
            OrderRoomViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }
    }
}

fun CreationExtras.aplikasiOrderRoom(): AplikasiOrderRoom =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiOrderRoom)