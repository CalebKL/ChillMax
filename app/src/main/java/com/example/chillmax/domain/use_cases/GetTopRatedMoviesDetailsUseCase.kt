package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.TopRatedMovies
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.domain.models.responses.TopRatedMoviesApiResponses
import com.example.chillmax.util.Resource

class GetTopRatedMoviesDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(movieId:Int): Resource<TopRatedMoviesDetails>{
        return repository.getTopRatedMoviesDetails(movieId = movieId)
    }
}