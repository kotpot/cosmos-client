
plugins {
    kotlin("multiplatform")
    alias(wireLibs.plugins.wire)
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

buildscript {
    dependencies {
        classpath("org.kotpot:wire-schema")
    }
}

wire {
    sourcePath {
        srcDir("proto")
    }
    custom {
        schemaHandlerFactory = org.szkug.krpc.plugin.KrpcSchemaHandlerFactory()
        out = "${buildDir}/generated"
        options = mapOf(
            "rpcRole" to "client"
        )
    }
}

kotlin {

    jvm() // MARK: jvm target could be desktop & android library
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    // https://youtrack.jetbrains.com/issue/KT-60734/
    applyDefaultHierarchyTemplate()

    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client)
                implementation(libs.ktor.cio)
            }
        }
        val commonMain by getting {
            dependencies {
                api(wireLibs.wire.runtime)
                api(wireLibs.wire.client)
            }
            iosMain.dependsOn(this)
        }
    }
}