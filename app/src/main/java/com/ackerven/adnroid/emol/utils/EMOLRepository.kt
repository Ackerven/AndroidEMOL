package com.ackerven.adnroid.emol.utils

import android.content.Context
import androidx.room.Room
import com.ackerven.adnroid.emol.database.EMOLDatabase
import com.ackerven.adnroid.emol.model.Config
import com.ackerven.adnroid.emol.model.Diary
import com.ackerven.adnroid.emol.model.Moon
import java.lang.IllegalStateException
import java.util.*

private const val DATABASE_NAME = "emol-database"

class EMOLRepository private constructor(context: Context) {

    private val database: EMOLDatabase = Room.databaseBuilder(
        context.applicationContext,
        EMOLDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val diaryDao = database.diaryDao()
    private val moonDao = database.moonDao()
    private val configDao = database.configDao()

    fun getDiarys(): List<Diary> = diaryDao.getDiarys()
    fun getDiary(id: UUID) = diaryDao.getDiary(id)
    fun updateDiary(diary: Diary) = diaryDao.updateDiary(diary)
    fun insertDiary(diary: Diary) = diaryDao.insertDiary(diary)
    fun deleteDiary(diary: Diary) = diaryDao.deleteDiary(diary.isDelete, diary.id)

    fun getMoons(): List<Moon> = moonDao.getMoons()
    fun getMoon(id: UUID) = moonDao.getMoon(id)
    fun updateMoon(moon: Moon) = moonDao.updateMoon(moon)
    fun deleteMoon(moon: Moon) = moonDao.deleteMoon(moon.isDelete, moon.id)
    fun insertMoon(moon: Moon) = moonDao.insertMoon(moon)

    fun getConfig(): List<Config> = configDao.getConfig()
    fun updateConfig(config: Config) = configDao.updateConfig(config)
    fun insertConfig(config: Config) = configDao.insertConfig(config)


    companion object {
        private var INSTANCE: EMOLRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = EMOLRepository(context)
            }
        }

        fun get(): EMOLRepository {
            return INSTANCE ?: throw IllegalStateException("EMOLRepository must be initialized")
        }
    }
}