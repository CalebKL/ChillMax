package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.TopRatedMovies
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class MovieCreditsApiResponses(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<MovieCredits>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
