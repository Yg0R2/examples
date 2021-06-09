import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    `java-library`
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.5.0"
}

allprojects {
    apply<DependencyManagementPlugin>()
    apply<JavaLibraryPlugin>()
    apply<SpringBootPlugin>()

    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }

    group = "yg0r2.example"
}

dependencies {
    api(project(":client-decorator"))

    implementation("org.springframework.boot", "spring-boot-starter-web")
}
