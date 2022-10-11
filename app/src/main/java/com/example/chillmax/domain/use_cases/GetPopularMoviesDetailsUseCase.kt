package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.responses.PopularMoviesApiResponses
import com.example.chillmax.util.Resource

class GetPopularMoviesDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(movieId:Int): Resource<PopularMoviesApiResponses>{
        return repository.getPopularMoviesDetails(movieId = movieId)
    }
}