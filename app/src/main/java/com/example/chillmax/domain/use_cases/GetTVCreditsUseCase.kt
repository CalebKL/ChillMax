package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.TVCredits
import com.example.chillmax.domain.models.responses.TVCreditsApiResponse
import com.example.chillmax.util.Resource

class GetTVCreditsUseCase(
    private val repository: Repository
){
    suspend operator fun invoke(tvSeriesId: Int): Resource<TVCredits>{
        return repository.getTVCredits(tvSeriesId = tvSeriesId)
    }
}