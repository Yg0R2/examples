plugins {
    id("spring-feign-project-convention")

    id("org.springframework.boot") version("2.7.1")
    id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

subprojects {
    apply(plugin = "spring-feign-project-convention")

    afterEvaluate {
        dependencies {
            implementation(rootProject)

            testFixturesImplementation(rootProject)
        }
    }
}
