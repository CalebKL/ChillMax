package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.TopRatedMovies
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class MovieCreditsApiResponses(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val casts: List<MovieCredits>
)
