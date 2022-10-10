package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVTopRated
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
data class TVTopRatedApiResponses(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("prevPage")
    val prevPage: Int? = null,
    @SerializedName("nextPage")
    val nextPage: Int? =null,
    @SerializedName("tvTopRated")
    val tvTopRated: List<TVTopRated> = emptyList()
)
