package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.MOVIE_CREDITS_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
data class MovieCredits(
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)