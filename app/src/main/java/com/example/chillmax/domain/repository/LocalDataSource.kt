package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.MyList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface LocalDataSource {
    fun getMyList(): Flow<List<MyList>>

    fun getSelectedFromMyList(listId: Int):MyList

    suspend fun addToMyList(myList:MyList)

    fun isHeroLiked(listId:Int): Flow<Boolean>

    suspend fun deleteOneFromMyList(myList: MyList)

    suspend fun deleteAllContentFromMyList()

}