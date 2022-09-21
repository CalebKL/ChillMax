package com.example.chillmax.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chillmax.data.local.ChillMaxDatabase
import com.example.chillmax.util.Constants.CHILL_MAX_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ChillMaxDatabase{
        return Room.databaseBuilder(
            context,
            ChillMaxDatabase::class.java,
            CHILL_MAX_DATABASE
        ).build()
    }
}