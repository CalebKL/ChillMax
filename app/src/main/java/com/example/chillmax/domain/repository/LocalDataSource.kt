package com.example.chillmax.domain.repository

import com.example.chillmax.domain.models.MyList

interface LocalDataSource {
    suspend fun myList(): MyList
}