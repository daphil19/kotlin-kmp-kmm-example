
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    base
    id("com.github.ben-manes.versions") version "0.36.0"
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    id("io.gitlab.arturbosch.detekt") version "1.14.1" apply false
}

allprojects {

    repositories {
        jcenter()
        mavenCentral()
    }
}

// checks to see if a release is "stable," meaning we don't have to worry about rc versions polluting a dependencyUpdates check
// this can be found in the versions plugin readme (https://github.com/ben-manes/gradle-versions-plugin)
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.named("dependencyUpdates", DependencyUpdatesTask::class.java).configure {
    // disallow release candidates as upgradable versions from stable versions
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }

    // don't look at gradle rc versions either
    gradleReleaseChannel = "current"
}

