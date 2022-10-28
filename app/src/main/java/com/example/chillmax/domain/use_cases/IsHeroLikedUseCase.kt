package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MyList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class IsHeroLikedUseCase(
    private val repository: Repository
) {
    operator fun invoke(myList: Int): Flow<Boolean> {
        return repository.isHeroLiked(myList = myList)
    }
}