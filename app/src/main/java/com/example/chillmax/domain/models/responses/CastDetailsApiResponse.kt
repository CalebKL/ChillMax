package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.CastDetails
import com.google.gson.annotations.SerializedName

data class CastDetailsApiResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val casts: List<CastDetails>
)
