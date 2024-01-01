
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(wireLibs.plugins.wire)
}

buildscript {
    dependencies {
        classpath("org.szkug.krpc:wire-schema")
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
        iosMain.dependencies {
            implementation(libs.ktor.cio)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.okhttp)
        }
        commonMain.dependencies {
            implementation(libs.ktor.core)
            implementation(libs.ktor.loging)
            api(libs.coroutines.core)
            api(wireLibs.wire.runtime)
            api(wireLibs.wire.client)
        }
    }
}