package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.UpcomingMovies
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingMoviesApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val genres: List<UpcomingMovies> = emptyList()
)
