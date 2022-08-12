plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()

    mavenCentral()
}

kotlinDslPluginOptions {
    jvmTarget.set(JavaVersion.VERSION_17.toString())
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-gradle-plugin", "+")

    implementation("org.springframework.cloud", "spring-cloud-dependencies", "+")

    // Plugins
    implementation("io.spring.dependency-management", "io.spring.dependency-management.gradle.plugin", "+")
    implementation("org.springframework.boot", "org.springframework.boot.gradle.plugin", "+")

    implementation("org.jetbrains.kotlin.plugin.spring", "org.jetbrains.kotlin.plugin.spring.gradle.plugin", "1.6.21")
}
