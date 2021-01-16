plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.parcelize")
}
group = "com.example.myapplication"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(project(":mobile:shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.example.myapplication.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    val compiler = javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(8))
    }

    kotlinOptions {
        jvmTarget = "1.8"
        jdkHome = compiler.get().metadata.installationPath.asFile.absolutePath
    }
}