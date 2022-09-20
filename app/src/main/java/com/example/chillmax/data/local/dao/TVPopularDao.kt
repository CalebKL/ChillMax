package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.TVPopular

@Dao
interface TVPopularDao {

    @Query("SELECT * FROM TV_POPULAR_TABLE ORDER BY id ASC")
    fun getAllTVPopular(): PagingSource<Int, TVPopular>

    @Query("SELECT * FROM TV_POPULAR_TABLE WHERE id =:tvPopularId")
    fun getSelectedTVPopular(tvPopularId: Int): TVPopular

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTVPopular(tvPopularList: List<TVPopular>)

    @Query("DELETE FROM TV_POPULAR_TABLE")
    suspend fun deleteAllTVPopular()
}
