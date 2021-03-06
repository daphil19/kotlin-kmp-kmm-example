import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js {
        browser {
            binaries.executable()
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
        val commonMain by getting {
            dependencies {
                api(project(":common"))
            }
        }
        val commonTest by getting
        val jvmMain by getting {
            dependencies {
                api(project(":common"))
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                api(project(":common"))
            }
        }
        val jsTest by getting
        val iosMain by getting {
            dependencies {
                api(project(":common"))
            }
        }
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
