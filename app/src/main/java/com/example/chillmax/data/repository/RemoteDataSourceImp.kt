package com.example.chillmax.data.repository

import android.util.Log
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
    override suspend fun getMovieDetails(filmId: Int):Resource<MoviesDetails> {
        val response = try {
            chillMaxApi.getMovieDetails(filmId)
        }catch (e:Exception){
            return Resource.Error("Unknown Error")
        }
        Log.d("MovieDetails", "$response")
        return Resource.Success(response)
    }

    override suspend fun getTVDetails(filmId: Int): Resource<TVDetails> {
        val response = try {
            chillMaxApi.getTVDetails(filmId)
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

    override fun getTVAiringToday(): Flow<PagingData<TVAiringToday>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVAiringTodaySource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override fun getTVTopRated(): Flow<PagingData<TVTopRated>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVTopRatedSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override fun getTVPopular(): Flow<PagingData<TVPopular>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                TVPopularSource(chillMaxApi = chillMaxApi)
            }
        ).flow
    }

    override suspend fun getCastDetails(filmId: Int): Resource<CastDetailsApiResponse> {
        val response = try {
            chillMaxApi.getMovieCredits(filmId = filmId)
        }catch (e:Exception){
            return Resource.Error("Unexpected Error")
        }
        Log.d("MovieCredits", "$response")
        return Resource.Success(response)
    }

    override fun multiSearch(query: String): Flow<PagingData<MultiSearch>> {
        val pagerResult = Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                MultiSearchSource(chillMaxApi = chillMaxApi, query = query)
            }
        ).flow
        return pagerResult
    }
}