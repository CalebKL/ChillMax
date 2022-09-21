package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVAiringToday
import kotlinx.serialization.Serializable

@Serializable
data class TVAiringTodayApiResponses(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val tvAiringToday: List<TVAiringToday> = emptyList()
)