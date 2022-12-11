package com.ackerven.adnroid.emol

import android.app.Application
import com.ackerven.adnroid.emol.utils.EMOLRepository

class EMOLIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        EMOLRepository.initialize(this)
    }
}