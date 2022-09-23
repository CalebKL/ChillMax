package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.GenresApiResponses
import com.example.chillmax.util.Resource

class GetMovieGenresUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Resource<GenresApiResponses>{
        return repository.getMovieGenres()
    }
}