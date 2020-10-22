plugins {
    base
    id("com.github.ben-manes.versions") version "0.29.0"
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1" // apply false
    id("io.gitlab.arturbosch.detekt") version "1.14.1" apply false
}

allprojects {

    repositories {
        jcenter()
        mavenCentral()
    }
}
