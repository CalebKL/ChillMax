package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.domain.models.UpcomingMovies

@Dao
interface UpcomingMoviesDao {

    @Query("SELECT * FROM UPCOMING_MOVIES_TABLE ORDER BY id ASC")
    fun getUpcomingMovies(): PagingSource<Int, UpcomingMovies>

    @Query("SELECT * FROM UPCOMING_MOVIES_TABLE WHERE id =:upcomingMoviesId")
    fun getSelectedUpcomingMovies(upcomingMoviesId: Int): UpcomingMovies

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUpcomingMovies(upcomingMoviesList: List<UpcomingMovies>)

    @Query("DELETE FROM UPCOMING_MOVIES_TABLE")
    suspend fun deleteAllUpcomingMovies()
}