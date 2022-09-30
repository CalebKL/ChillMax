package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MyList

class GetSelectedFromMyListUseCase(
    private val repository: Repository
) {
    operator fun invoke(listId: Int): MyList{
        return repository.getSelectedFromMyList(listId = listId)
    }
}