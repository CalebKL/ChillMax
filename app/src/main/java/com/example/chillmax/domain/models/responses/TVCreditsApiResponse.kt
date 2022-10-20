package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.TVCredits
import com.google.gson.annotations.SerializedName


data class TVCreditsApiResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("casts")
    val casts: List<TVCredits>
)
