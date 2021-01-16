import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

dependencies {
    api(project(":common"))
}

val compiler = javaToolchains.compilerFor {
    languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        jdkHome = compiler.get().metadata.installationPath.asFile.absolutePath
    }
}
