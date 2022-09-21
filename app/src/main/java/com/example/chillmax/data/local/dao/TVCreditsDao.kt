package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.TVCredits

interface TVCreditsDao {
    @Query("SELECT * FROM TV_CREDITS_TABLE ORDER BY id ASC")
    fun getAllTVCredits(): PagingSource<Int, TVCredits>

    @Query("SELECT * FROM TV_CREDITS_TABLE WHERE id =:tvCreditsId")
    fun getSelectedTVCredits(tvCreditsId: Int): TVCredits

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTVCredits(movieCreditsList: List<TVCredits>)

    @Query("DELETE FROM TV_CREDITS_TABLE")
    suspend fun deleteAllTVCredits()
}