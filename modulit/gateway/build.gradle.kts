allprojects {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:+")
        }
    }
}

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    `java-library`
    id("org.springframework.boot") version "2.4.1"
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
}
