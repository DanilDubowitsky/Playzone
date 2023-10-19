plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)
                implementation(Dependencies.Kotlin.Serialization.serializationJson)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.negotation)
                implementation(Dependencies.Ktor.serialization_json)

                implementation(Dependencies.Settings.core)
                implementation(Dependencies.Settings.noargs)

                api(Dependencies.Koin.core)
                api(Dependencies.Koin.annotations)

                api(Dependencies.SqlDelight.core)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SqlDelight.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    database("Database") {
        packageName = "com.game.playzone"
        schemaOutputDirectory = file("src/commonMain/sqldelight/databases/schema")
        migrationOutputDirectory = file("src/commonMain/sqldelight/databases/migrations")
    }
}
