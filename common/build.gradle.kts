import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.4.10"
}

kotlin {
    jvm()
    // NOTE this is the deployed js target since kmm can't support multiple js targets
    js {
        browser {
            binaries.executable()
        }
    }
    ios()

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "8" // can't go past java 8 so that we can use it in android
    }
}
