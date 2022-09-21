package com.example.chillmax.data.repository

import com.example.chillmax.data.local.ChillMaxDatabase
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.repository.LocalDataSource

class LocalDataSourceImp(
    chillMaxDatabase: ChillMaxDatabase
): LocalDataSource {
    override suspend fun getSelectedGenres(genreId: Int): Genres {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedMovieCredits(movieCreditsId: Int): MovieCredits {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedPopularMovies(popularMovieId: Int): PopularMovies {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedTopRatedMovies(topRatedMovieId: Int): TopRatedMovies {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedTVAiringToday(tvAiringTodayId: Int): TVAiringToday {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedTVCredits(tvCreditsId: Int): TVCredits {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedTVPopular(tvPopularId: Int): TVPopular {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedTVTopRated(tvTopRatedId: Int): TVTopRated {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedUpcomingMovies(upcomingMoviesId: Int): UpcomingMovies {
        TODO("Not yet implemented")
    }
}