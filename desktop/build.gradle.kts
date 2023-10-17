import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

dependencies {
    api(project(":shared"))
    implementation(compose.desktop.currentOs)
    implementation(libs.compose.material3)
    implementation(libs.java.stream.player)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "$group.desktop"
            packageVersion = version.toString()
        }
    }
}