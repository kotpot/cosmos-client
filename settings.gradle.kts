pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "cosmos-client"

// gradle feature
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("shared")
include("desktop")
include("shared:network")

includeBuild("plugin-build") {
    dependencySubstitution {
        substitute(module("org.kotpot:wire-schema")).using(project(":wire-schema"))
    }
}