object Dependencies {

    object Koin {
        private const val version = "3.2.2"
        private const val kspVersion = "1.1.0"
        const val core = "io.insert-koin:koin-core:$version"
        const val annotations = "io.insert-koin:koin-annotations:$kspVersion"
        const val ksp = "io.insert-koin:koin-ksp-compiler:$kspVersion"
    }

    object Settings {
        const val core = "com.russhwolf:multiplatform-settings:1.0.0-RC"
        const val noargs = "com.russhwolf:multiplatform-settings-no-arg:1.0.0-RC"
    }

    object Image {

        object Coil {
            private const val version = "2.4.0"
            const val coil = "io.coil-kt:coil:$version"
            const val coilCompose = "io.coil-kt:coil-compose:$version"
        }
    }

    object Kotlin {
        private const val version = "1.7.10"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.5.31"
            const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.1"
        }

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.2.0-beta01"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Ktor {
        private const val version = "2.1.0"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val negotation = "io.ktor:ktor-client-content-negotiation:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
        const val serialization_json = "io.ktor:ktor-serialization-kotlinx-json:$version"
    }

    object SqlDelight {
        private const val version = "1.5.3"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val core = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val desktop = "com.squareup.sqldelight:sqlite-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.2.2"
        const val composeActivty = "androidx.activity:activity-compose:1.5.1"

        object Compose {
            private const val version = "1.2.0"
            const val ui ="androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val icons = "androidx.compose.material:material-icons-core:$version"
        }
    }

    object Other {
        object ViewModel {
            private const val version = "0.7.1"

            const val core = "com.adeo:kviewmodel:$version"
            const val compose = "com.adeo:kviewmodel-compose:$version"
            const val odyssey = "com.adeo:kviewmodel-odyssey:$version"
        }

        object Navigation {
            private const val version = "1.0.0-beta15"

            const val core = "io.github.alexgladkov:odyssey-core:$version"
            const val compose = "io.github.alexgladkov:odyssey-compose:$version"
        }
    }
}