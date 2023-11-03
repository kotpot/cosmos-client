plugins {
    kotlin("multiplatform")
    alias(libs.plugins.compose.multiplatform)
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
                // implementation(libs.ktor.protobuf)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.loging)
                api(libs.koin.core)
                api(libs.vlcj)
                api(project(":cosmos-protocol"))

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)

            }
        }
        val desktopMain by getting {
            dependencies {
                dependsOn(commonMain)
            }
        }
    }
}