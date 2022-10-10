package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TopRatedMovies
import com.google.gson.annotations.SerializedName


data class TopRatedMoviesApiResponses(
    @SerializedName("page")
    val page: Int,
    @SerializedName("searches")
    val searches: List<TopRatedMovies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
