package com.example.chillmax.data.remote

import com.example.chillmax.domain.models.TopRatedMovies
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.util.Constants.API_KEY
import com.example.chillmax.util.Constants.STARTING_PAGE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChillMaxApi {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): GenresApiResponses

    @GET("genre/tv/list")
    suspend fun getTvShowsGenres(
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): GenresApiResponses

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): PopularMoviesApiResponses

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): TopRatedMoviesApiResponses

    @GET("/movie/{movie_id}")
    suspend fun getTopRatedMoviesDetails(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): TopRatedMoviesDetails


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): UpcomingMoviesApiResponses

    @GET("tv/airing_today")
    suspend fun getTVAiringToday(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): TVAiringTodayApiResponses

    @GET("tv/top_rated")
    suspend fun getTVTopRated(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): TVTopRatedApiResponses

    @GET("tv/popular")
    suspend fun getTVPopular(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): TVPopularApiResponses

    @GET("tv/{tv_id}/credits")
    suspend fun getTVCredits(
        @Path("tv_id") tvSeriesId: Int,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): TVCreditsApiResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String = API_KEY,
        @Query("language") language: String = "en-US",
    ): MovieCreditsApiResponses

    @GET("search/movie")
    suspend fun multiSearch(
        @Query("page") page :Int = STARTING_PAGE,
        @Query("api_key") api_key: String = API_KEY,
        @Query("query") query: String,
    ): MultiSearchApiResponse
}