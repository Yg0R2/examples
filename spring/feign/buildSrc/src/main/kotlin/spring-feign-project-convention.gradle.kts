plugins {
    id("org.jetbrains.kotlin.jvm")

    id("java")
    id("java-test-fixtures")
}

apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")

group = "yg0r2.example.spring.feign"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.majorVersion))
    }
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.toString()))
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-web")

    // Test dependencies
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}
