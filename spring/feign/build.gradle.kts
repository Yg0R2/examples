plugins {
    id("spring-feign-project-convention")

    id("org.springframework.boot") version("2.7.1")
    id("io.spring.dependency-management") version("1.0.11.RELEASE")

    id("org.jetbrains.kotlin.plugin.spring") version("1.6.21") apply(false)
}

subprojects {
    apply(plugin = "spring-feign-project-convention")
}
