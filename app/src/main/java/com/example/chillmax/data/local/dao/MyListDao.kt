package com.example.chillmax.data.local.dao

import androidx.room.*
import com.example.chillmax.domain.models.MyList
import kotlinx.coroutines.flow.Flow

@Dao
interface MyListDao {
    @Query("SELECT * FROM MY_LIST_TABLE ORDER BY id ASC")
    fun getMyList(): Flow<List<MyList>>

    @Query("SELECT * FROM MY_LIST_TABLE  WHERE id =:listId")
    fun getSelectedFromMyList(listId: Int):MyList

    @Insert
    fun addToMyList(myList: MyList)

    @Query("SELECT isLiked FROM my_list_table WHERE id = :listId")
    fun isHeroLiked(listId: Int):Flow<Boolean>

    @Delete
    suspend fun deleteOneFromMyList(myList: MyList)

    @Query("DELETE FROM MY_LIST_TABLE")
    suspend fun deleteAllContentFromMyList()
}