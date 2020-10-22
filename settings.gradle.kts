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
}

rootProject.name = "kotlin-kmp-kmm"

include(":common")
include(":server")
include(":mobile")
include(":mobile:shared")
include(":mobile:androidApp")
