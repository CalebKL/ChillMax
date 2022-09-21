package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.TopRatedMovies
import kotlinx.serialization.Serializable


@Serializable
data class TopRatedMoviesApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val genres: List<TopRatedMovies> = emptyList()
)