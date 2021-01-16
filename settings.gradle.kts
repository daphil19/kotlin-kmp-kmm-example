pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
    val pluginVersion = "1.4.21"
    plugins {
        kotlin("multiplatform") version pluginVersion apply false
        kotlin("jvm") version pluginVersion apply false
        kotlin("js") version pluginVersion apply false
    }
}

rootProject.name = "kotlin-kmp-kmm-example"

include(":common")
include(":server")
include(":client")
include(":mobile")
include(":mobile:shared")
include(":mobile:androidApp")
