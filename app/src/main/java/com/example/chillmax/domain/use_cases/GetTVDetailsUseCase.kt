package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.TVDetails
import com.example.chillmax.util.Resource

class GetTVDetailsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(filmId:Int): Resource<TVDetails>{
       return repository.getTVDetails(filmId)
    }
}