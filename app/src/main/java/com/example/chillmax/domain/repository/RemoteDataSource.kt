package com.example.chillmax.domain.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getMovieDetails(movieId: Int): Resource<MoviesDetails>
    suspend fun getTVDetails(tvId: Int): Resource<TVDetails>
    suspend fun getMovieGenres(): Resource<GenresApiResponses>
    suspend fun getTvShowsGenres(): Resource<GenresApiResponses>
    fun getPopularMovies(): Flow<PagingData<PopularMovies>>
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>>
    fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>>
    fun getTVAiringToday(): Flow<PagingData<TVAiringToday>>
    fun getTVTopRated(): Flow<PagingData<TVTopRated>>
    fun getTVPopular(): Flow<PagingData<TVPopular>>
    suspend fun getTVCredits(tvSeriesId: Int): Resource<TVCreditsApiResponse>
    suspend fun getMovieCredits(movieId:Int): Resource<MovieCreditsApiResponses>
    fun multiSearch(query: String): Flow<PagingData<MultiSearch>>
}