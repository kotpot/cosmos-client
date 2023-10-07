plugins {
    kotlin("multiplatform")
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

kotlin {
    jvm("desktop")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client)
                implementation(libs.ktor.cio)
                implementation(libs.ktor.protobuf)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.loging)

                implementation(libs.koin.core)
            }
        }
        val desktopMain by getting {
            dependsOn(commonMain)
        }
    }
}