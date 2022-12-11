package com.ackerven.adnroid.emol.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ackerven.adnroid.emol.model.Config

@Dao
interface ConfigDao {
    @Query("SELECT * FROM `config`")
    fun getConfig(): List<Config>

    @Update
    fun updateConfig(config: Config)

    @Insert
    fun insertConfig(config: Config)
}