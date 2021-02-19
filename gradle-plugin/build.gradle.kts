plugins {
    jacoco
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "yg0r2.examples"
version = "0.0.1-SNAPSHOT"

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
    implementation("org.springframework.boot", "spring-boot-gradle-plugin", "2.4.1")
    implementation("io.spring.gradle", "dependency-management-plugin", "1.0.10.RELEASE")

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
