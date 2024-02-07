dependencyResolutionManagement {
    versionCatalogs {
        create("wireLibs") {
            from(files("krpc-wire-plugin/gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "cosmos-client"

// gradle feature
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

includeBuild("krpc-wire-plugin") {
    dependencySubstitution {
        substitute(module("org.szkug.krpc:wire-schema")).using(project(":wire-schema"))
    }
}

// TODO -> remove
include("shared")
include("desktop")
// TODO <- END

include("shared:network")
include("shared:ui")
include("apps:android")
