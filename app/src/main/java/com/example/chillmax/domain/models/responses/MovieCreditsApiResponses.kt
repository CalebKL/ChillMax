package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.MovieCredits
import kotlinx.serialization.Serializable

@Serializable
data class MovieCreditsApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val movieCredits: List<MovieCredits> = emptyList()
)
