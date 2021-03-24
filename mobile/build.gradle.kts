// add google repository for mobile (mavenCentral is defined at top level)
subprojects {
    repositories {
        google()
        jcenter() // task :mobile:shared:extractDebugAnnotations still requires something from jcenter
    }
}
