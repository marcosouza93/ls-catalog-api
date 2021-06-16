tasks {
    withType(Jar::class) {
        enabled = true
    }
}

dependencies {
    implementation("javax.inject:javax.inject:1")
    implementation("io.projectreactor:reactor-core:3.4.4")
    testImplementation("io.projectreactor:reactor-test:3.4.4")
}