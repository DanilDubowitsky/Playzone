plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(Dependencies.Android.gradlePlugin)
    implementation(Dependencies.Kotlin.kotlinPlugin)
    implementation(Dependencies.Compose.gradlePlugin)
    implementation(Dependencies.Kotlin.Serialization.gradlePlugin)
    implementation(Dependencies.SqlDelight.gradlePlugin)
    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.annotations)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}