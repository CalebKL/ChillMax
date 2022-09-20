package com.example.chillmax.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.chillmax.domain.models.Genres

@Dao
interface GenresDao {

    @Query("SELECT * FROM GENRE_TABLE ORDER BY id ASC")
    fun getAllGenres(): PagingSource<Int, Genres>

    @Query("SELECT * FROM GENRE_TABLE WHERE id =:genreId")
    fun getSelectedGenres(genreId: Int): Genres

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenres(genres: List<Genres>)

    @Query("DELETE FROM GENRE_TABLE")
    suspend fun deleteAllGenres()
}