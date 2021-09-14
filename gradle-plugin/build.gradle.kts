plugins {
    jacoco
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

buildscript {
    dependencies {
        classpath("org.owasp:dependency-check-gradle:6.3.1")
    }
}

// https://github.com/dependency-check/dependency-check-gradle
apply(plugin = "org.owasp.dependencycheck")

repositories {
    mavenCentral()
}

group = "yg0r2.examples"

gradlePlugin {
    plugins {
        create("generatePlugin") {
            id = "generate"
            implementationClass = "generate.GenerateFilesPlugin"
        }

        create("greetingPlugin") {
            id = "greeting"
            implementationClass = "greeting.GreetingPlugin"
        }

        create("dependencyPlugin") {
            id = "dependency"
            implementationClass = "yg0r2.examples.DependencyPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }

    if (!version.toString().endsWith("SNAPSHOT")) {
        repositories {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/Yg0R2/examples/${project.rootProject.name}")
                credentials(PasswordCredentials::class)
            }
        }

        publications {
            create<MavenPublication>("github") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                from(project.components.getByName("kotlin"))
            }
        }
    }
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-gradle-plugin", "+")
    implementation("io.spring.gradle", "dependency-management-plugin", "+")

    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "+")
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
