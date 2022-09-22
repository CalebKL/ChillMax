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
    fun getAllHero(): PagingSource<Int, MyList>

    @Query("SELECT * FROM MY_LIST_TABLE  WHERE id =:heroId")
    fun getSelectedHero(heroId: Int):MyList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHeroes(heroes: List<MyList>)

    @Query("DELETE FROM MY_LIST_TABLE")
    suspend fun deleteAllHero()
}