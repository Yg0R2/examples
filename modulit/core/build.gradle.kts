import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar
import yg0r2.examples.configure.MavenPublishConfiguration

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/Yg0R2/examples/")
            credentials(PasswordCredentials::class)
        }
    }
    dependencies {
        classpath("yg0r2.examples:gradle-plugin:+")
    }
}

apply(plugin = "dependency")

plugins {
    `java-library`
}

MavenPublishConfiguration(rootProject).apply()

tasks {
    named("bootBuildImage", BootBuildImage::class.java) {
        enabled = false
    }

    named("bootJar", BootJar::class.java) {
        enabled = false
    }

    named("jar", Jar::class.java) {
        enabled = true
    }
}

dependencies {
    api("org.springframework.boot", "spring-boot-starter-data-redis")

    api("org.springframework.session", "spring-session-data-redis")
}
