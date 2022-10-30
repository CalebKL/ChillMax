package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class IfExistsUseCase(
    private val repository: Repository
) {
     suspend operator fun invoke(listId:Int):Int {
        return repository.ifExists(listId)
    }
}