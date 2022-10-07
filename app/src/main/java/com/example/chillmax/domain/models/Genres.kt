package com.example.chillmax.domain.models

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Genres(
    val id: Int,
    val name: String
)