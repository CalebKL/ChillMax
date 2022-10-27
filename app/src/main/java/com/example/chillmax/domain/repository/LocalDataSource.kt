package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.MyList
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getMyList(): Flow<List<MyList>>

    fun getSelectedFromMyList(listId: Int):MyList

    fun addToMyList(myList:MyList)

    suspend fun deleteOneFromMyList(myList: MyList)

    suspend fun deleteAllContentFromMyList()

}