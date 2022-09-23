package com.example.chillmax.domain.use_cases

import androidx.paging.PagingData
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.UpcomingMovies
import kotlinx.coroutines.flow.Flow

class GetUpcomingMoviesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<PagingData<UpcomingMovies>> {
        return repository.getUpcomingMovies()
    }
}