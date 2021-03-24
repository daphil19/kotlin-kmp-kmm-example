pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
    val kotlinVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
    }
}

// The mobile modules require this, but putting it at the "mobile root" level brings up a warning about loading the
// plugin multiple times
buildscript {
    repositories {
        gradlePluginPortal()
        google()
    }
    val kotlinVersion: String by settings
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:4.1.1")
    }
}

rootProject.name = "kotlin-kmp-kmm-example"

include(":common")
include(":server")
include(":client")
include(":mobile")
include(":mobile:shared")
include(":mobile:androidApp")
