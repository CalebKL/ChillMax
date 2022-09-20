package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVTopRated
import kotlinx.serialization.Serializable

@Serializable
data class TVTopRatedApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val genres: List<TVTopRated> = emptyList()
)
