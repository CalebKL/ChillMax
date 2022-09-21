package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.*

interface LocalDataSource {
    suspend fun getSelectedGenres(genreId: Int): Genres
    suspend fun getSelectedMovieCredits(movieCreditsId: Int): MovieCredits
    suspend fun getSelectedPopularMovies(popularMovieId: Int): PopularMovies
    suspend fun getSelectedTopRatedMovies(topRatedMovieId: Int): TopRatedMovies
    suspend fun getSelectedTVAiringToday(tvAiringTodayId: Int): TVAiringToday
    suspend fun getSelectedTVCredits(tvCreditsId: Int): TVCredits
    suspend fun getSelectedTVPopular(tvPopularId: Int): TVPopular
    suspend fun getSelectedTVTopRated(tvTopRatedId: Int): TVTopRated
    suspend fun getSelectedUpcomingMovies(upcomingMoviesId: Int): UpcomingMovies

}