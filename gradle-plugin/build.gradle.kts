version = "0.0.1-SNAPSHOT"
group = "yg0r2.examples"

plugins {
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
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
        if (isRelease()) {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/Yg0R2/examples/${project.rootProject.name}")
                credentials(PasswordCredentials::class)
            }
        }
    }

    if (isRelease()) {
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

fun isRelease(): Boolean = !version.toString().endsWith("SNAPSHOT")
