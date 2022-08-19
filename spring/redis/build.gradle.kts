plugins {
    id("example-spring-project-convention")
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-cache")
    implementation("org.springframework.boot", "spring-boot-starter-data-redis")

    implementation("org.springdoc", "springdoc-openapi-ui", "+")
}
