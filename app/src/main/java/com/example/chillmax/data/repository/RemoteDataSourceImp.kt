package com.example.chillmax.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.chillmax.data.paging_source.*
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.repository.RemoteDataSource
import com.example.chillmax.util.Constants.ITEMS_PER_PAGE
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImp(
    private val chillMaxApi: ChillMaxApi
):RemoteDataSource {
    override suspend fun getMovieDetails(movieId: Int):Resource<MoviesDetails> {
        val response = try {
            chillMaxApi.getMovieDetails(movieId)
        }catch (e:Exception){
            return Resource.Error("Unknown Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getMovieGenres(): Resource<GenresApiResponses> {
        val response = try {
            chillMaxApi.getMovieGenres()
        }catch (e: Exception){
            return Resource.Error("Unknown Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getTvShowsGenres(): Resource<GenresApiResponses> {
        val response = try {
            chillMaxApi.getTvShowsGenres()
        }catch (e:Exception){
            return Resource.Error("Unknown Error")
        }
        return Resource.Success(response)
    }

    override fun getPopularMovies(): Flow<PagingData<PopularMovies>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                PopularMoviesSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getPopularMoviesDetails(movieId: Int): Resource<PopularMoviesApiResponses> {
        val response = try {
            chillMaxApi.getPopularMovies(movieId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TopRatedMoviesSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                UpcomingMoviesSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getUpcomingMoviesDetails(movieId: Int): Resource<UpcomingMoviesApiResponses> {
        val response = try {
            chillMaxApi.getUpcomingMovies(movieId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override fun getTVAiringToday(): Flow<PagingData<TVAiringToday>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVAiringTodaySource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getTVAiringTodayDetails(tvId: Int): Resource<TVAiringTodayApiResponses> {
        val response = try {
            chillMaxApi.getTVAiringToday(tvId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override fun getTVTopRated(): Flow<PagingData<TVTopRated>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVTopRatedSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getTVTopRatedDetails(tvId: Int): Resource<TVTopRatedApiResponses> {
        val response = try {
            chillMaxApi.getTVTopRated(tvId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override fun getTVPopular(): Flow<PagingData<TVPopular>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVPopularSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getTVPopularDetails(tvId: Int): Resource<TVPopularApiResponses> {
        val response = try {
            chillMaxApi.getTVPopular(tvId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getTVCredits(tvSeriesId: Int): Resource<TVCreditsApiResponse> {
        val response = try {
            chillMaxApi.getTVCredits(tvSeriesId = tvSeriesId)
        }catch (e: Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getMovieCredits(movieId: Int): Resource<MovieCreditsApiResponses> {
        val response = try {
            chillMaxApi.getMovieCredits(movieId = movieId)
        }catch (e:Exception){
            return Resource.Error("Unexpected Error")
        }
        return Resource.Success(response)
    }

    override fun multiSearch(query: String): Flow<PagingData<MultiSearch>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                MultiSearchSource(chillMaxApi = chillMaxApi, query = query)
            }
        ).flow
    }
}