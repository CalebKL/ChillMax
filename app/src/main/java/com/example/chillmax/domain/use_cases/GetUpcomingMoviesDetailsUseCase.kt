package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.UpcomingMoviesApiResponses
import com.example.chillmax.util.Resource

class GetUpcomingMoviesDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(movieId:Int): Resource<UpcomingMoviesApiResponses>{
        return repository.getUpcomingMoviesDetails(movieId = movieId)
    }
}