import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
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

val compiler = javaToolchains.compilerFor {
    languageVersion.set(JavaLanguageVersion.of(8))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8" // can't go past java 8 so that we can use it in android
        jdkHome = compiler.get().metadata.installationPath.asFile.absolutePath
    }
}
