package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.responses.TVAiringTodayApiResponses
import com.example.chillmax.util.Resource

class GetTVAiringDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tvId:Int): Resource<TVAiringTodayApiResponses>{
        return repository.getTVAiringTodayDetails(tvId = tvId)
    }
}