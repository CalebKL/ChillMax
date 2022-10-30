package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.MyList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface LocalDataSource {
    fun getMyList(): Flow<List<MyList>>

    fun getSelectedFromMyList(listId: Int):MyList

    suspend fun addToMyList(myList:MyList)

    suspend fun ifExists(listId:Int):Int

    suspend fun deleteOneFromMyList(myList: Int)

    suspend fun deleteAllContentFromMyList()

}