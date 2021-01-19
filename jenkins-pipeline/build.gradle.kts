plugins {
    groovy
    jacoco
    `java-library`
}

group = "org.examples"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven(url = "https://repo.jenkins-ci.org/public")
    maven(url = "https://repo.jenkins-ci.org/releases")
}

sourceSets {
    main {
        withConvention(GroovySourceSet::class) {
            groovy.srcDirs("src", "vars")
        }
    }

    test {
        withConvention(GroovySourceSet::class) {
            groovy.srcDirs("test")
        }
    }
}

tasks {
    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    test {
        useJUnitPlatform()

        configure<JacocoTaskExtension> {
            classDumpDir = file("${buildDir}/jacoco/classDump/")
        }
    }

    check {
        finalizedBy(jacocoTestReport, jacocoTestCoverageVerification)
    }

    create("prepareJacoco", Copy::class) {
        mustRunAfter(test)

        delete {
            delete("${buildDir}/jacoco/classes/")
        }

        val includePatterns = fileTree("${buildDir}/classes/groovy/main/") {
                excludes.addAll(listOf("**/*_closure*.*"))
            }
            .map { it.path }
            .map { it.substring("${buildDir}/classes/groovy/main/".length) }
            .map { it.substring(0, it.lastIndexOf(".")) + "*.class" }

        from(
            fileTree("${buildDir}/jacoco/classDump/") {
                includes.addAll(includePatterns)
                excludes.addAll(listOf("**/*_closure*.*", "**/*Test*.*"))
            }
        )

        into("${buildDir}/jacoco/classes/")
    }

    check {
        finalizedBy("jacocoTestReport", "jacocoTestCoverageVerification")
    }

    jacocoTestReport {
        dependsOn("prepareJacoco")

        classDirectories.setFrom("${buildDir}/jacoco/classes/")
    }

    jacocoTestCoverageVerification {
        dependsOn("prepareJacoco")

        classDirectories.setFrom("${buildDir}/jacoco/classes/")
    }
}

dependencies {
    implementation("org.codehaus.groovy", "groovy-all", "+")

    compileOnly("org.jenkins-ci.main", "jenkins-core", "+")
    compileOnly("org.jenkins-ci.plugins.workflow", "workflow-aggregator", "+")
    compileOnly("org.jenkins-ci.plugins.workflow", "workflow-cps", ext = "jar")

    testImplementation("com.lesfurets", "jenkins-pipeline-unit","+")

    testImplementation("org.junit.jupiter", "junit-jupiter", "+")
}
