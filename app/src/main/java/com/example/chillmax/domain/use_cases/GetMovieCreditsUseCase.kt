package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.util.Resource

class GetMovieCreditsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(movieId: Int): Resource<MovieCreditsApiResponses> {
        return repository.getMovieCredits(movieId = movieId)
    }
}