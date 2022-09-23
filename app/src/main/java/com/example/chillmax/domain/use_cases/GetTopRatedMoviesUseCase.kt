package com.example.chillmax.domain.use_cases

import androidx.paging.PagingData
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.TopRatedMovies
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(
    private val repository: Repository)
{
    suspend operator fun invoke(): Flow<PagingData<TopRatedMovies>> {
        return repository.getTopRatedMovies()
    }
}
