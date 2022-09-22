package com.example.chillmax.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chillmax.data.local.dao.ChillMaxRemoteKeyDao
import com.example.chillmax.data.local.dao.MyListDao
import com.example.chillmax.domain.models.ChillMaxRemoteKeys
import com.example.chillmax.domain.models.MyList

@Database(entities = [MyList::class, ChillMaxRemoteKeys::class], version = 1)
abstract class ChillMaxDatabase: RoomDatabase() {
    abstract fun chillMaxRemoteKeyDao(): ChillMaxRemoteKeyDao
    abstract fun myListDao(): MyListDao
}