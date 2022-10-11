package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.TVTopRatedApiResponses
import com.example.chillmax.util.Resource

class GetTVTopRatedDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tvId:Int): Resource<TVTopRatedApiResponses>{
        return repository.getTVTopRatedDetails(tvId = tvId)
    }
}