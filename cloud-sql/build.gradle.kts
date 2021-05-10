plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.4.5"
    `java-library`
}

group = "yg0r2.example"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    api(platform("com.google.cloud:spring-cloud-gcp-dependencies:+"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:+"))

    implementation("com.google.cloud:spring-cloud-gcp-starter-sql-mysql")
//    implementation("com.google.cloud.sql:mysql-socket-factory-connector-j-8:1.2.3")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}

