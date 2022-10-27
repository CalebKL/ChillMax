package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.MY_LIST_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName =MY_LIST_DATABASE_TABLE)
data class MyList(
    val isLiked: Boolean,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val imagePath: String?,
    val title: String,
    val description: String,
    val mediaType: String,
    val rating: Double,
    val addedOn: String
)

