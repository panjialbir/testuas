package com.example.testuas.repository

import com.example.testuas.data.LC
import kotlinx.coroutines.flow.Flow

interface RepositoryLc {
    fun getAllLC(): Flow<List<LC>>

    fun getLC(id: Int): Flow<LC>

    suspend fun insertLC(lc: LC)

    suspend fun deleteLC(lc: LC)

    suspend fun updateLC(lc: LC)
}