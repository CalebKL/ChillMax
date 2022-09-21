package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.MovieCredits

interface MovieCreditsDao {
    @Query("SELECT * FROM MOVIE_CREDITS_TABLE ORDER BY id ASC")
    fun getAllMovieCredits(): PagingSource<Int, MovieCredits>

    @Query("SELECT * FROM MOVIE_CREDITS_TABLE WHERE id =:movieCreditsId")
    fun getSelectedMovieCredits(movieCreditsId: Int): MovieCredits

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieCredits(movieCreditsList: List<MovieCredits>)

    @Query("DELETE FROM MOVIE_CREDITS_TABLE")
    suspend fun deleteAllMovieCredits()
}