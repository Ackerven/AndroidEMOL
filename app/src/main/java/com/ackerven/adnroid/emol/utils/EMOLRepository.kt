package com.ackerven.adnroid.emol.utils

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.ackerven.adnroid.emol.database.EMOLDatabase
import com.ackerven.adnroid.emol.model.Config
import com.ackerven.adnroid.emol.model.Diary
import com.ackerven.adnroid.emol.model.Moon
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

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

    private val executor = Executors.newSingleThreadExecutor()

    fun getDiarys(): LiveData<List<Diary>> = diaryDao.getDiarys()
    fun getDiary(id: UUID): LiveData<Diary?> = diaryDao.getDiary(id)
    fun updateDiary(diary: Diary) {
        executor.execute {
            diaryDao.updateDiary(diary)
        }
    }
    fun insertDiary(diary: Diary) {
        executor.execute {
            diaryDao.insertDiary(diary)
        }
    }
    fun deleteDiary(diary: Diary) {
        executor.execute {
            diaryDao.deleteDiary(diary.isDelete, diary.id)
        }
    }

    fun getMoons(): LiveData<List<Moon>> = moonDao.getMoons()
    fun getMoon(id: UUID): LiveData<Moon?> = moonDao.getMoon(id)
    fun updateMoon(moon: Moon) {
        executor.execute {
            moonDao.updateMoon(moon)
        }
    }
    fun deleteMoon(moon: Moon) {
        executor.execute {
            moonDao.deleteMoon(moon.isDelete, moon.id)
        }
    }
    fun insertMoon(moon: Moon) {
        executor.execute {
            moonDao.insertMoon(moon)
        }
    }

    fun getConfig(): LiveData<List<Config>> = configDao.getConfig()
    fun updateConfig(config: Config) {
        executor.execute {
            configDao.updateConfig(config)
        }
    }
    fun insertConfig(config: Config) {
        executor.execute {
            configDao.insertConfig(config)
        }
    }


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