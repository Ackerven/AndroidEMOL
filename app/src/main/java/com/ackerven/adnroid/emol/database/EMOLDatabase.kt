package com.ackerven.adnroid.emol.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ackerven.adnroid.emol.model.Config
import com.ackerven.adnroid.emol.model.Diary
import com.ackerven.adnroid.emol.model.Moon

@Database(entities = [Moon::class, Diary::class, Config::class], version = 1, exportSchema = false)
@TypeConverters(EMOLConverter::class)
abstract class EMOLDatabase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao
    abstract fun moonDao(): MoonDao
    abstract fun configDao(): ConfigDao
}