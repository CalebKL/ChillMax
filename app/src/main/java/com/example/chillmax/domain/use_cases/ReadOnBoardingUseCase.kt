package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke():Flow<Boolean>{
        return repository.readOnBoardingState()
    }
}