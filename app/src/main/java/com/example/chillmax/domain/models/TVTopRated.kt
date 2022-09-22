package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.TV_TOP_RATED_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
data class TVTopRated(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)