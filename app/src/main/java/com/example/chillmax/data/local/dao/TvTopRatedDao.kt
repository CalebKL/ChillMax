package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.TVPopular
import com.example.chillmax.domain.models.TVTopRated

@Dao
interface TvTopRatedDao {

    @Query("SELECT * FROM TV_TOP_RATED_TABLE ORDER BY id ASC")
    fun getAllTVTopRated(): PagingSource<Int, TVTopRated>

    @Query("SELECT * FROM TV_TOP_RATED_TABLE WHERE id =:tvTopRatedId")
    fun getSelectedTVTopRated(tvTopRatedId: Int): TVTopRated

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTVTopRated(TVTopRatedList: List<TVTopRated>)

    @Query("DELETE FROM TV_TOP_RATED_TABLE")
    suspend fun deleteAllTVTopRated()
}