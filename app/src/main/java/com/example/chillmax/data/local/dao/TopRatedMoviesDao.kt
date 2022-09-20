package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chillmax.domain.models.TopRatedMovies

@Dao
interface TopRatedMoviesDao {
    @Query("SELECT * FROM TOP_RATED_MOVIES_TABLE ORDER BY id ASC")
    fun getAllTopRatedMovies(): PagingSource<Int, TopRatedMovies>

    @Query("SELECT * FROM TOP_RATED_MOVIES_TABLE WHERE id =:topRatedMovie")
    fun getSelectedTopRatedMovies(topRatedMovie: Int): TopRatedMovies

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTopRatedMovies(topRatedMoviesList: List<TopRatedMovies>)

    @Query("DELETE FROM TOP_RATED_MOVIES_TABLE")
    suspend fun deleteAllTopRatedMovies()
}