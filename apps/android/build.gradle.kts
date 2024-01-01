plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

android {
    namespace = providers.gradleProperty("group").get()
    compileSdk = 34
    defaultConfig {
        //noinspection EditedTargetSdkVersion
        targetSdk = 34
        minSdk = 26
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.coroutines.android)

    // move to common
    implementation(platform(libs.compose.bom))

    implementation(libs.compose.activity)

    implementation(projects.shared.network)
    implementation(projects.shared.ui)

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

kotlin {
    jvmToolchain(17)
}