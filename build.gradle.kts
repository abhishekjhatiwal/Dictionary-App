// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    // Android Gradle Plugin
    id("com.android.application") version "8.7.3" apply false

    // Kotlin Android Plugin
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false

    // Hilt for Dependency Injection
    id("com.google.dagger.hilt.android") version "2.52" apply false

    // Kotlin Compose Plugin (optional but useful for Compose projects)
    alias(libs.plugins.kotlin.compose) apply false


//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.kotlin.android) apply false
//    alias(libs.plugins.kotlin.compose) apply false
//    // Add the Hilt plugin
//    id("com.google.dagger.hilt.android") version "2.57.2" apply false
}