package com.example.chillmax.data.repository

import com.example.chillmax.data.local.ChillMaxDatabase
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.repository.LocalDataSource

class LocalDataSourceImp(
    chillMaxDatabase: ChillMaxDatabase
): LocalDataSource {
    private val genresDao = chillMaxDatabase.genresDao()
    private val movieCreditsDao = chillMaxDatabase.movieCreditsDao()
    private val popularMoviesDao = chillMaxDatabase.popularMoviesDao()
    private val topRatedMoviesDao = chillMaxDatabase.topRatedMoviesDao()
    private val tvAiringTodayDao = chillMaxDatabase.tvAiringTodayDao()
    private val tvCreditsDao = chillMaxDatabase.tvCreditsDao()
    private val tvPopularDao = chillMaxDatabase.tvPopularDao()
    private val tvTopRatedDao = chillMaxDatabase.tvTopRatedDao()
    private val upcomingMoviesDao= chillMaxDatabase.upcomingMoviesDao()

    override suspend fun getSelectedGenres(genreId: Int): Genres {
        return  genresDao.getSelectedGenres(genreId= genreId)
    }

    override suspend fun getSelectedMovieCredits(movieCreditsId: Int): MovieCredits {
        return movieCreditsDao.getSelectedMovieCredits(movieCreditsId = movieCreditsId)
    }

    override suspend fun getSelectedPopularMovies(popularMovieId: Int): PopularMovies {
        return popularMoviesDao.getSelectedPopularMovies(popularMovieId = popularMovieId)
    }

    override suspend fun getSelectedTopRatedMovies(topRatedMovieId: Int): TopRatedMovies {
        return topRatedMoviesDao.getSelectedTopRatedMovies(topRatedMovieId = topRatedMovieId)
    }

    override suspend fun getSelectedTVAiringToday(tvAiringTodayId: Int): TVAiringToday {
       return tvAiringTodayDao.getSelectedTVAiringToday(tvAiringTodayId = tvAiringTodayId)
    }

    override suspend fun getSelectedTVCredits(tvCreditsId: Int): TVCredits {
        return tvCreditsDao.getSelectedTVCredits(tvCreditsId = tvCreditsId)
    }

    override suspend fun getSelectedTVPopular(tvPopularId: Int): TVPopular {
        return tvPopularDao.getSelectedTVPopular(tvPopularId = tvPopularId)
    }

    override suspend fun getSelectedTVTopRated(tvTopRatedId: Int): TVTopRated {
        return tvTopRatedDao.getSelectedTVTopRated(tvTopRatedId = tvTopRatedId)
    }

    override suspend fun getSelectedUpcomingMovies(upcomingMoviesId: Int): UpcomingMovies {
        return upcomingMoviesDao.getSelectedUpcomingMovies(upcomingMoviesId = upcomingMoviesId)
    }
}