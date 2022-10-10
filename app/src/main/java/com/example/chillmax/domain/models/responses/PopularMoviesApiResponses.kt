package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.TVTopRated
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesApiResponses(
    @SerializedName("page")
    val page: Int,
    @SerializedName("searches")
    val searches: List<PopularMovies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
