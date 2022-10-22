package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.CastDetailsApiResponse
import com.example.chillmax.util.Resource

class CastDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(filmId: Int): Resource<CastDetailsApiResponse> {
        return repository.getCastDetails(filmId = filmId)
    }
}