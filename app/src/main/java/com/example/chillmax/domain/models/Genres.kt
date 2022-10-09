package com.example.chillmax.domain.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
@Serializable
data class Genres(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String
)