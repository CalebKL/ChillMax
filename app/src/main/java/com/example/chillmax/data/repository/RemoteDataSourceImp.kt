package com.example.chillmax.data.repository

import androidx.paging.PagingData
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImp(
    private val chillMaxDatabase: ChillMaxDatabase,
    private val chillMaxApi: ChillMaxApi
):RemoteDataSource {
    override fun getMovieGenres(): Flow<PagingData<Genres>> {
        TODO("Not yet implemented")
    }

    override fun getTvShowsGenres(): Flow<PagingData<Genres>> {
        TODO("Not yet implemented")
    }

    override fun getPopularMovies(): Flow<PagingData<PopularMovies>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> {
        TODO("Not yet implemented")
    }

    override fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>> {
        TODO("Not yet implemented")
    }

    override fun getTVAiringToday(): Flow<PagingData<TVAiringToday>> {
        TODO("Not yet implemented")
    }

    override fun getTVTopRated(): Flow<PagingData<TVTopRated>> {
        TODO("Not yet implemented")
    }

    override fun getTVPopular(): Flow<PagingData<TVPopular>> {
        TODO("Not yet implemented")
    }

    override fun getTVCredits(): Flow<PagingData<TVCredits>> {
        TODO("Not yet implemented")
    }

    override fun getMovieCredits(): Flow<PagingData<MovieCredits>> {
        TODO("Not yet implemented")
    }

    override fun multiSearch(): Flow<PagingData<MultiSearch>> {
        TODO("Not yet implemented")
    }
}