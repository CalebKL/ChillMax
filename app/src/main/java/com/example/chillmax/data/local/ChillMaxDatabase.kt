package com.example.chillmax.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.chillmax.data.local.dao.*
import com.example.chillmax.domain.models.*

@Database(entities = [Genres::class, PopularMovies::class, TopRatedMovies::class, TVAiringToday::class, TVPopular::class, TVTopRated::class, UpcomingMovies::class], version = 1)
@TypeConverters()
abstract class ChillMaxDatabase: RoomDatabase(){
    abstract fun genresDao(): GenresDao
    abstract fun popularMoviesDao(): PopularMoviesDao
    abstract fun topRatedMoviesDao(): TopRatedMoviesDao
    abstract fun tvAiringTodayDao(): TVAiringTodayDao
    abstract fun tvPopularDao(): TVPopularDao
    abstract fun tvTopRatedDao(): TVTopRatedDao
    abstract fun upcomingMoviesDao(): UpcomingMoviesDao
}