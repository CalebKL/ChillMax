package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.CHILL_MAX_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = CHILL_MAX_REMOTE_KEYS_DATABASE_TABLE)
data class ChillMaxRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
