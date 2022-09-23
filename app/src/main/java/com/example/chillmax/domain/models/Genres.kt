package com.example.chillmax.domain.models

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class Genres(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)