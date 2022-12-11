package com.ackerven.adnroid.emol.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ackerven.adnroid.emol.model.Diary
import java.util.*

@Dao
interface DiaryDao {
    @Query("SELECT * FROM `diary`")
    fun getDiarys(): List<Diary>

    @Query("SELECT * FROM `diary` WHERE `id` = (:id)")
    fun getDiary(id: UUID): Diary?

    @Update
    fun updateDiary(diary: Diary)

    @Insert
    fun insertDiary(diary: Diary)

    @Query("UPDATE `diary` SET `isDelete` = (:isDelete) WHERE `id` = (:id)")
    fun deleteDiary(isDelete: Boolean, id: UUID)

}