package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVPopular
import com.example.chillmax.domain.models.TVTopRated
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class TVPopularApiResponses(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<TVPopular>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
