version = "0.0.1-SNAPSHOT"
group = "yg0r2.examples"

plugins {
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
            implementationClass = "GreetingPlugin"
        }
    }
}
