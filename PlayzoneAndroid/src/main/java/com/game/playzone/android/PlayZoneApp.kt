package com.game.playzone.android

import PlatformConfiguration
import android.app.Application
import initKoin

class PlayZoneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(PlatformConfiguration(applicationContext))
    }
}
