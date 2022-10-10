package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TopRatedMovies
import com.google.gson.annotations.SerializedName


data class TopRatedMoviesApiResponses(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("prevPage")
    val prevPage: Int? = null,
    @SerializedName("nextPage")
    val nextPage: Int? =null,
    @SerializedName("topRatedMovies")
    val topRatedMovies: List<TopRatedMovies> = emptyList()
)
