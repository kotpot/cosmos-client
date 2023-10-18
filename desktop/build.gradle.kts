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
    implementation(libs.koin.compose)
}

compose.desktop {
    application {
        mainClass = "org.kotpot.cosmos.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Exe, TargetFormat.Deb)
            modules("java.instrument", "java.management", "java.naming", "jdk.unsupported")

            packageName = "Cosmos"
            packageVersion = "1.0.0"
            vendor = "kotpot"

            copyright = "© 2023 kotpot. Licensed under the MIT License."
            licenseFile.set(project.file("../LICENSE"))

            appResourcesRootDir.set(project.layout.projectDirectory.dir("resources"))

            windows {
                iconFile.set(File("launcher_icons/windows_logo.ico"))
                menuGroup = "Cosmos"
            }

            linux {
                iconFile.set(File("launcher_icons/linux_logo.png"))
                menuGroup = "Cosmos"
            }

            macOS {
                iconFile.set(File("launcher_icons/macos_logo.png"))
                bundleID = "org.kotpot.cosmos"
            }
        }
    }
}