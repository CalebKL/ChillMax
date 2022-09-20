package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.GENRE_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = GENRE_DATABASE_TABLE)
data class Genres(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)