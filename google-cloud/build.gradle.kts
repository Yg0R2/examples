plugins {
    `java-library`
}

allprojects {
    apply {
        plugin("java-library")
    }

    group = "yg0r2.example"

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    }
}
