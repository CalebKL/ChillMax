package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import kotlinx.coroutines.flow.Flow
import java.sql.RowId

interface LocalDataSource {
    fun getMyList(): Flow<List<MyList>>

    fun getSelectedFromMyList(listId: Int):MyList

    fun addToMyList(myList: List<MyList>)

    suspend fun deleteOneFromMyList(myList: MyList)

    suspend fun deleteAllContentFromMyList()

}