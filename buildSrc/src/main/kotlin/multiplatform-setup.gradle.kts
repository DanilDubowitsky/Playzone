import gradle.kotlin.dsl.accessors._8db2c3a11b2d3d9784e8da7dde233a5d.kotlin

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
}

kotlin {
    jvm("desktop")
    android()
    ios()

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}