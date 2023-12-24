dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// gradle feature
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("wire-schema")