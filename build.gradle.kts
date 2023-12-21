import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.wire) apply false
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://jitpack.io")
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs += "-Xcontext-receivers"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.ExperimentalStdlibApi"

        // https://youtrack.jetbrains.com/issue/KT-61573
       //  kotlinOptions.freeCompilerArgs += "-Xexpect-actual-classes"
    }
}