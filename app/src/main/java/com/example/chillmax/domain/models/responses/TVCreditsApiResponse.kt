package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVCredits
import com.google.gson.annotations.SerializedName


data class TVCreditsApiResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<TVCredits>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
