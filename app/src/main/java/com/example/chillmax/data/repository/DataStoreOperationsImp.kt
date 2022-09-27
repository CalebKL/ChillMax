package com.example.chillmax.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.chillmax.domain.repository.DataStoreOperations
import com.example.chillmax.util.Constants.PREFERENCE_KEY
import com.example.chillmax.util.Constants.PREFERENCE_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCE_NAME)

class DataStoreOperationsImp @Inject constructor(
    @ApplicationContext private var context: Context
): DataStoreOperations {
    private object PreferenceKeys{
        val onBoardingKeys = booleanPreferencesKey(PREFERENCE_KEY)
    }
    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preference->
            preference[PreferenceKeys.onBoardingKeys] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
       return dataStore.data
           .catch { exception->
               if (exception is IOException){
                   emit(emptyPreferences())
               }else{
                   throw exception
               }
           }
           .map { preference->
               val onBoardingState = preference[PreferenceKeys.onBoardingKeys]?: false
               onBoardingState
           }
    }
}