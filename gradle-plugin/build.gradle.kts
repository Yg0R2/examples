version = "0.0.1-SNAPSHOT"
group = "yg0r2.examples"

plugins {
    kotlin("jvm") version "1.3.72"
    jacoco
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    repositories {
        mavenLocal()
    }
}

gradlePlugin {
    plugins {
        create("greetingPlugin") {
            id = "yg0r2.examples.greeting"
            implementationClass = "greeting.GreetingPlugin"
        }
        create("myDependencies") {
            id = "yg0r2.examples.dependency"
            implementationClass = "yg0r2.examples.MyPlugin"
        }
    }
}

dependencies {
    api("org.springframework.boot", "spring-boot-gradle-plugin", "2.3.3.RELEASE")
    api("io.spring.gradle", "dependency-management-plugin", "1.0.10.RELEASE")

    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.6.2")
}

tasks {
    jacocoTestReport {
        reports.html.isEnabled = true
    }

    test {
        finalizedBy(jacocoTestReport, jacocoTestCoverageVerification)

        useJUnitPlatform()
    }
}
