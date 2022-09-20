package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.PopularMovies

@Dao
interface PopularMoviesDao {

    @Query("SELECT * FROM POPULAR_MOVIES_TABLE ORDER BY id ASC")
    fun getAllPopularMovies(): PagingSource<Int, PopularMovies>

    @Query("SELECT * FROM POPULAR_MOVIES_TABLE WHERE id =:popularMovie")
    fun getSelectedPopularMovies(popularMovie: Int): PopularMovies

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPopularMovies(popularMoviesList: List<PopularMovies>)

    @Query("DELETE FROM POPULAR_MOVIES_TABLE")
    suspend fun deleteAllPopularMovies()
}