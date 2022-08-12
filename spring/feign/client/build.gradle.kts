dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:+")
    }
}

dependencies {
    implementation("org.springframework.cloud", "spring-cloud-starter-circuitbreaker-reactor-resilience4j")
    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign")

    implementation("io.github.openfeign", "feign-okhttp")
    implementation("io.github.openfeign", "feign-httpclient")
}
