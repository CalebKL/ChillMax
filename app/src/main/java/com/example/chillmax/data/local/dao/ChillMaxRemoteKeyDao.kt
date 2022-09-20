package com.example.chillmax.data.local.dao

import androidx.room.*
import com.example.chillmax.domain.models.ChillMaxRemoteKeys

@Dao
interface ChillMaxRemoteKeyDao {

    @Query("SELECT * FROM CHILL_MAX_REMOTE_KEYS_TABLE WHERE id=:remoteKey")
    suspend fun getChillMaxRemoteKeys(remoteKey: Int): ChillMaxRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(chillMaxRemoteKeys: List<ChillMaxRemoteKeys>)

    @Query("DELETE FROM CHILL_MAX_REMOTE_KEYS_TABLE")
    suspend fun deleteAllRemoteKeys()
}