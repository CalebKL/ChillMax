package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed:Boolean){
        repository.saveOnBoardingState(completed = completed)
    }
}