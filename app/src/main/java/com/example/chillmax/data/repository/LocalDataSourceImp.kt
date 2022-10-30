package com.example.chillmax.data.repository

import com.example.chillmax.data.local.ChillMaxDatabase
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class LocalDataSourceImp(
    chillMaxDatabase: ChillMaxDatabase
): LocalDataSource {

    private val dao = chillMaxDatabase.myListDao()

    override fun getMyList(): Flow<List<MyList>> {
        return dao.getMyList()
    }

    override fun getSelectedFromMyList(listId: Int): MyList {
        return dao.getSelectedFromMyList(listId = listId)
    }

    override suspend fun addToMyList(myList: MyList) {
        return dao.addToMyList(myList = myList)
    }

    override suspend fun ifExists(listId: Int): Int {
        return dao.ifExists(listId)
    }

    override suspend fun deleteOneFromMyList(myList: Int) {
        return dao.deleteOneFromMyList(myList)
    }

    override suspend fun deleteAllContentFromMyList() {
        return dao.deleteAllContentFromMyList()
    }
}