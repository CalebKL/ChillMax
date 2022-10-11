package com.example.chillmax.domain.models

import com.google.gson.annotations.SerializedName

data class TVPopular(
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @SerializedName("first_air_date")
    val first_air_date: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val origin_country: List<String>,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int
)