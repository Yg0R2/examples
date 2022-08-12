import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")

    id("java")
    id("java-test-fixtures")

    id("io.spring.dependency-management")
    id("org.springframework.boot")

    id("org.jetbrains.kotlin.plugin.spring")
}

group = "yg0r2.example.spring.${rootProject.name}"

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
        languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.toString()))
    }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.allWarningsAsErrors = true
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    test {
        useJUnitPlatform()
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:+")
    }
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-web")

    // Test dependencies
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}
