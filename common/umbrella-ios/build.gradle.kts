plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "PlayZone IOS SDK"
        homepage = "https://github.com/DanilDubowitsky/Playzone"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:core-utils"))
            export(project(":common:auth:api"))
            export(project(":common:auth:presentation"))
            export(project(":common:games:api"))
            export(project(":common:umbrella-core"))
            export(project(":common:main:api"))
            export(project(":common:main:presentation"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:api"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:games:api"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:main:api"))
                implementation(project(":common:main:presentation"))
            }
        }

        iosMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:core-utils"))
                api(project(":common:auth:api"))
                api(project(":common:auth:presentation"))
                api(project(":common:games:api"))
                api(project(":common:umbrella-core"))
                api(project(":common:main:api"))
                api(project(":common:main:presentation"))
            }
        }
    }
}