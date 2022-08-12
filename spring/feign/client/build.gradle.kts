dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:+")
    }
}

dependencies {
    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign")
}
