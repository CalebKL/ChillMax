package com.example.chillmax.domain.use_cases

import androidx.paging.PagingData
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.TVTopRated
import kotlinx.coroutines.flow.Flow

class TVTopRatedUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<PagingData<TVTopRated>> {
        return repository.getTVTopRated()
    }
}