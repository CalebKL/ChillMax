package com.example.chillmax.domain.use_cases

import androidx.paging.PagingData
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.responses.GenresApiResponses
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow

class GetPopularMoviesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<PagingData<PopularMovies>> {
        return repository.getPopularMovies()
    }
}