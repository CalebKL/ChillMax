package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.PopularMovies
import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val genres: List<PopularMovies> = emptyList()
)
