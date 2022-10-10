package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.MultiSearch
import com.google.gson.annotations.SerializedName

data class MultiSearchApiResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("searches")
    val searches: List<MultiSearch>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
