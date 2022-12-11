package com.ackerven.adnroid.emol.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ackerven.adnroid.emol.model.Moon
import java.util.*

@Dao
interface MoonDao {
    @Query("SELECT * FROM `moon`")
    fun getMoons(): List<Moon>

    @Query("SELECT * FROM `moon` WHERE `id` = (:id)")
    fun getMoon(id: UUID): Moon?

    @Update
    fun updateMoon(moon: Moon)

    @Query("UPDATE `moon` SET `isDelete` = (:isDelete) WHERE `id` = (:id)")
    fun deleteMoon(isDelete: Boolean, id: UUID)

    @Insert
    fun insertMoon(moon: Moon)
}