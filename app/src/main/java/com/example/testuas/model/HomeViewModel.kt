package com.example.testuas.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testuas.data.OrderRoom
import com.example.testuas.repository.OfflineRepositoryLc
import com.example.testuas.repository.OfflineRepositoryOrder
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(private val repositoryOrder: OfflineRepositoryOrder,
                    private val repositoryLC: OfflineRepositoryLc
) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    data class HomeUiState(
        val listOrder: List<OrderRoom> = listOf()
    )

    val homeUiStateLC: StateFlow<HomeUiState> = repositoryOrder.getAllOrderStream()
    val homeUiState: StateFlow<HomeUiState> = repositoryOrder.getAllOrderStream()
        .filterNotNull()
        .map { HomeUiState(listOrder = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )
}