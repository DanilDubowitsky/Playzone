plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    kotlin("android").apply(false)
    kotlin("multiplatform").apply(false)
    id("com.google.devtools.ksp") version "1.8.21-1.0.11"
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.10"))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
