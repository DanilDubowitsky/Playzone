package com.game.playzone.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class PlayZoneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }

}

fun PlayZoneApp.initPlatformSDK() =
    PlatformSDK.init(configuration = PlatformConfiguration(context = applicationContext))
