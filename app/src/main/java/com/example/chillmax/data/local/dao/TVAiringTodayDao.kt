package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.TopRatedMovies

@Dao
interface TVAiringTodayDao {
    @Query("SELECT * FROM TV_AIRING_TODAY_TABLE ORDER BY id ASC")
    fun getAllTVAiringToday(): PagingSource<Int, TVAiringToday>

    @Query("SELECT * FROM TV_AIRING_TODAY_TABLE WHERE id =:tvAiringToday")
    fun getSelectedTVAiringToday(tvAiringToday: Int): TVAiringToday

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTVAiringToday(TVAiringTodayList: List<TVAiringToday>)

    @Query("DELETE FROM TV_AIRING_TODAY_TABLE")
    suspend fun deleteAllTVAiringToday()
}