package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.TVPopularApiResponses
import com.example.chillmax.util.Resource

class GetTVPopularDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tvId:Int): Resource<TVPopularApiResponses>{
        return repository.getTVPopularDetails(tvId = tvId)
    }
}