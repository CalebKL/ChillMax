package com.example.chillmax.domain.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getMovieDetails(movieId: Int): Resource<MoviesDetails>
    suspend fun getMovieGenres(): Resource<GenresApiResponses>
    suspend fun getTvShowsGenres(): Resource<GenresApiResponses>
    fun getPopularMovies(): Flow<PagingData<PopularMovies>>
    suspend fun getPopularMoviesDetails(movieId:Int):Resource<PopularMoviesApiResponses>
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>>
    fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>>
    suspend fun getUpcomingMoviesDetails(movieId:Int):Resource<UpcomingMoviesApiResponses>
    fun getTVAiringToday(): Flow<PagingData<TVAiringToday>>
    suspend fun getTVAiringTodayDetails(tvId:Int):Resource<TVAiringTodayApiResponses>
    fun getTVTopRated(): Flow<PagingData<TVTopRated>>
    suspend fun getTVTopRatedDetails(tvId:Int):Resource<TVTopRatedApiResponses>
    fun getTVPopular(): Flow<PagingData<TVPopular>>
    suspend fun getTVPopularDetails(tvId:Int): Resource<TVPopularApiResponses>
    suspend fun getTVCredits(tvSeriesId: Int): Resource<TVCredits>
    suspend fun getMovieCredits(movieId:Int): Resource<MovieCredits>
    fun multiSearch(query: String): Flow<PagingData<MultiSearch>>
}