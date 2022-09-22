package com.example.chillmax.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chillmax.data.local.dao.ChillMaxRemoteKeyDao
import com.example.chillmax.domain.models.ChillMaxRemoteKeys

@Database(entities = [ChillMaxRemoteKeys::class], version = 1)
abstract class ChillMaxDatabase: RoomDatabase() {
    abstract val chillMaxRemoteKeyDao: ChillMaxRemoteKeyDao
}