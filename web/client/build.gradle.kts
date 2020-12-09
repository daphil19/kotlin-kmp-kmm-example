plugins {
    kotlin("js")
}

// NOTE this is the deployed js target since kmm can't support multiple js targets
kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
}

dependencies {
    api(project(":common"))
}