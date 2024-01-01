plugins {
    kotlin("multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

// TODO remove this module
kotlin {
    jvm("desktop")
    sourceSets {
        val desktopMain by getting {
            dependencies {
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.core)
                implementation(libs.ktor.cio)
                // implementation(libs.ktor.protobuf)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.loging)
                api(libs.koin.core)
                api(libs.vlcj)

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }

            desktopMain.dependsOn(this)
        }
    }
}

