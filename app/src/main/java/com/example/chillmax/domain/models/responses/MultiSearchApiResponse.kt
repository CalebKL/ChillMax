package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.MultiSearch

data class MultiSearchApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val movies: List<MultiSearch> = emptyList()
)
