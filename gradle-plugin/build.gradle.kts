plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.30"
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
        create("greetingPlugin") {
            id = "greeting"
            implementationClass = "greeting.GreetingPlugin"
        }

        create("myDependencies") {
            id = "dependency"
            implementationClass = "yg0r2.examples.MyPlugin"
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
    api("org.springframework.boot", "spring-boot-gradle-plugin", "2.4.1")
    api("io.spring.gradle", "dependency-management-plugin", "1.0.10.RELEASE")

    implementation(kotlin("stdlib", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION)) // or "stdlib-jdk8"
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1") // JVM dependency

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
