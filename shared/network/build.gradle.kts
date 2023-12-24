
plugins {
    kotlin("multiplatform")
    id("com.squareup.wire")
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
        schemaHandlerFactory = org.kotpot.krpc.KrpcSchemaHandlerFactory()
        out = "${buildDir}/generated"
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
                api(libs.wire.runtime)
                api(libs.wire.client)
            }
            iosMain.dependsOn(this)
        }
    }
}