version = "0.0.1-SNAPSHOT"
group = "yg0r2.examples"

plugins {
    kotlin("jvm") version "1.4.10"
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
    }
}

dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.5.2")
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
