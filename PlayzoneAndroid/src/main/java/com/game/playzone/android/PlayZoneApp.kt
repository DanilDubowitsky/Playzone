package com.game.playzone.android

import PlatformDataSDK
import android.app.Application
import platform.PlatformConfiguration

class PlayZoneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }

}

fun PlayZoneApp.initPlatformSDK() =
    PlatformDataSDK.init(configuration = PlatformConfiguration(context = applicationContext))
