package com.game.playzone.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class PlayZoneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }

}

fun PlayZoneApp.initPlatformSDK() =
    PlatformSDK.init(configuration = PlatformConfiguration(context = applicationContext))
