plugins {
    id("java")
}

apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

group = "yg0r2.example.spring.jpa"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.majorVersion))
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
    implementation("org.springframework.boot", "spring-boot-starter-web")

    runtimeOnly("com.h2database", "h2")

    // Test dependencies
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}
