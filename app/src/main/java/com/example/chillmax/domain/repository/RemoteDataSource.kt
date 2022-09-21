package com.example.chillmax.domain.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getMovieGenres(): Flow<PagingData<Genres>>
    fun getTvShowsGenres(): Flow<PagingData<Genres>>
    fun getPopularMovies(): Flow<PagingData<PopularMovies>>
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>>
    fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>>
    fun getTVAiringToday(): Flow<PagingData<TVAiringToday>>
    fun getTVTopRated(): Flow<PagingData<TVTopRated>>
    fun getTVPopular(): Flow<PagingData<TVPopular>>
    fun getTVCredits(): Flow<PagingData<TVCredits>>
    fun getMovieCredits(): Flow<PagingData<MovieCredits>>
    fun multiSearch(): Flow<PagingData<MultiSearch>>

}