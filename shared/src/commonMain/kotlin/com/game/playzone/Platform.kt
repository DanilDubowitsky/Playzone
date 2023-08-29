package com.game.playzone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform