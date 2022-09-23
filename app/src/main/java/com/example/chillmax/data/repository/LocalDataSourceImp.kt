package com.example.chillmax.data.repository

import com.example.chillmax.data.local.ChillMaxDatabase
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

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

    override fun addToMyList(myList: List<MyList>) {
        return dao.addToMyList(myList = myList)
    }

    override suspend fun deleteOneFromMyList(myList: MyList) {
        return dao.deleteOneFromMyList(myList = myList)
    }

    override suspend fun deleteAllContentFromMyList() {
        return dao.deleteAllContentFromMyList()
    }
}