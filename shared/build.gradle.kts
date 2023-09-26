plugins {
    kotlin("multiplatform")
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

kotlin {
    jvm("desktop")
    sourceSets {
        val commonMain by getting
        val desktopMain by getting {
            dependsOn(commonMain)
        }
    }
}