pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Playzone"
include(":PlayzoneAndroid")
include(":shared")
include(":common:auth")
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
include(":common:core")