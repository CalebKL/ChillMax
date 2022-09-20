package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.Genres
import kotlinx.serialization.Serializable

@Serializable
data class GenresApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val genres: List<Genres> = emptyList()
)
