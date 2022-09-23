package com.example.chillmax.domain.use_cases

import androidx.paging.PagingData
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MultiSearch
import com.example.chillmax.domain.models.TopRatedMovies
import kotlinx.coroutines.flow.Flow

class MultiSearchUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<PagingData<MultiSearch>> {
        return repository.multiSearch()
    }
}