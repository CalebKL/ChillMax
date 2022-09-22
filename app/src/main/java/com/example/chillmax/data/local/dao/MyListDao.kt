package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.MyList

@Dao
interface MyListDao {

    @Query("SELECT * FROM MY_LIST_TABLE ORDER BY id ASC")
    suspend fun getMyList(): PagingSource<Int, MyList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMyList(myList:List<MyList>)

    @Query("SELECT * FROM MY_LIST_TABLE WHERE id=:myListId")
    suspend fun selectMyList(myListId: Int):MyList

    @Query("DELETE FROM MY_LIST_TABLE")
    suspend fun deleteMyList()
}