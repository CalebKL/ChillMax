package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVCredits
import com.example.chillmax.domain.models.TopRatedMovies
import kotlinx.serialization.Serializable

@Serializable
data class TVCreditsApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val tvCredits: List<TVCredits> = emptyList()
)
