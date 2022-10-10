package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TopRatedMovies
import com.google.gson.annotations.SerializedName


data class TopRatedMoviesApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    @SerializedName("topRatedMovies")
    val topRatedMovies: List<TopRatedMovies> = emptyList()
)
