plugins {
    id("spring-jpa-project-convention")

    id("org.springframework.boot") version("2.7.1")
    id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

subprojects {
    apply(plugin = "spring-jpa-project-convention")
}
