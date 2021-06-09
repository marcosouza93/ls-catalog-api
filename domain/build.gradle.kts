tasks {
    withType(Jar::class) {
        enabled = true
    }
}

dependencies {
    implementation("javax.inject:javax.inject:1")
}