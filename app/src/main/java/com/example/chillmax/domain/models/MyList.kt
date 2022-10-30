package com.example.chillmax.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chillmax.util.Constants.MY_LIST_DATABASE_TABLE
import com.example.chillmax.util.Constants.TABLE_NAME
import kotlinx.serialization.Serializable

@Entity(tableName =TABLE_NAME)
data class MyList(
    @PrimaryKey
    val listId: Int,
    val imagePath: String?,
    val title: String,
    val description: String,
    val mediaType: String
)

