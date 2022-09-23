package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MyList

class DeleteAllContentFromMyListUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(){
        return repository.deleteAllContentFromMyList()
    }
}