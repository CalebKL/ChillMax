package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.UpcomingMovies
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMoviesApiResponses(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<UpcomingMovies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

