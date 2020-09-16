package yg0r2.examples

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.exclude
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar
import yg0r2.examples.generate.FileDataExtension
import yg0r2.examples.generate.GenerateTask
import yg0r2.examples.model.Dependency
import java.util.*

class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.group = "yg0r2.examples"

        // Depending on other plugin
        project.allprojects.forEach {
            if (!it.name.endsWith("ui")) {
                it.plugins.apply {
                    apply(DependencyManagementPlugin::class.java)
                    apply(JavaPlugin::class.java)
                    apply(JavaLibraryPlugin::class.java)
                    apply(SpringBootPlugin::class.java)
                }

                it.repositories.addAll(listOf(
                    project.repositories.mavenLocal(),
                    project.repositories.mavenCentral()
                ))
            }
        }

        project.subprojects.forEach {
            it.tasks.named("bootJar", BootJar::class.java) {
                enabled = false
            }

            it.tasks.named("jar", Jar::class.java) {
                enabled = true
            }
        }

        val apiProject = getSubProject(project.subprojects, "api")
        apiProject.ifPresent {
            getDependencySet(it, "api").apply {
                add(it.dependencies.create("javax.validation", "validation-api", "+"))
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("com.fasterxml.jackson.core", "jackson-annotations", "+"))
                add(it.dependencies.create("com.fasterxml.jackson.core", "jackson-databind", "+"))
                add(it.dependencies.create("org.apache.commons", "commons-lang3", "+"))
            }
        }

        val clientProject = getSubProject(project.subprojects, "client")
        clientProject.ifPresent {
            getDependencySet(it, "api").apply {
                apiProject.ifPresent { project -> add(it.dependencies.create(project)) }
            }
        }

        val daoProject = getSubProject(project.subprojects, "dao")
        daoProject.ifPresent {
            getDependencySet(it, "api").apply {
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-data-jpa"))
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("com.h2database", "h2"))
                add(it.dependencies.create("org.apache.commons", "commons-lang3", "+"))
                add(it.dependencies.create("org.springframework", "spring-context"))
            }
        }

        val serviceProject = getSubProject(project.subprojects, "service")
        serviceProject.ifPresent {
            getDependencySet(it, "api").apply {
                apiProject.ifPresent { project -> add(it.dependencies.create(project)) }
                daoProject.ifPresent { project -> add(it.dependencies.create(project)) }
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("org.springframework.security", "spring-security-core"))
            }
        }

        val webProject = getSubProject(project.subprojects, "web")
        webProject.ifPresent {
            getDependencySet(it, "api").apply {
                serviceProject.ifPresent { project -> add(it.dependencies.create(project)) }

                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-data-redis"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-security"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-thymeleaf"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-web"))
                add(it.dependencies.create("org.springframework.session", "spring-session-data-redis"))
            }
        }

        // Execute in case of JavaPlugin present
        val javaPluginAction = Action<JavaPlugin> {
            println("Jee JavaPlugin found :)")
        }
        project.plugins.withType(JavaPlugin::class.java, javaPluginAction)

        // Add project dependencies
        getDependencySet(project).apply {
            webProject.ifPresent { project -> add(project.dependencies.create(project)) }
        }

        getDependencySet(project, "testImplementation").apply {
            add(project.dependencies.create("org.springframework.boot:spring-boot-starter-test"))
        }

        // Excluding dependency https://docs.gradle.org/current/userguide/resolution_rules.html
        val excludedDependencies = readJsonResource<List<Dependency>>("excludedDependencies.json")
        project.configurations.all {
            excludedDependencies.forEach {
                exclude(it.group, it.module)
            }
        }

        // Gradle automatically use `junit-jupiter` from any (transitive) dependencies instead of `junit`
//        project.dependencies.modules {
//            module("junit:junit") {
//                replacedBy("org.junit.jupiter:junit-jupiter", "junit is deprecated, have to use junit-jupiter")
//            }
//        }

        val fileDataExtension = project.extensions.create("fileData", FileDataExtension::class.java, project)
        project.tasks.register("generate", GenerateTask::class.java) {
            content.set(fileDataExtension.content)
            fileCount.set(fileDataExtension.fileCount)
        }

        project.repositories.addAll(listOf(
            project.repositories.mavenLocal(),
            project.repositories.mavenCentral()
        ))

        project.tasks.named("test", Test::class.java) {
            useJUnitPlatform()
        }

        project.configure<JavaPluginConvention> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

    private inline fun <reified T> readJsonResource(resourcePath: String): T {
        val url = javaClass.classLoader.getResource(resourcePath) ?: throw IllegalArgumentException("Resource does not exist: $resourcePath")

        return Json.decodeFromString(url.readText())
    }

    private fun getDependencySet(it: Project, name: String = "implementation") = it.configurations.getByName(name).dependencies

    private fun getSubProject(subProjects: Set<Project>, name: String): Optional<Project> {
        return subProjects.stream()
            .filter { it.name == name }
            .findFirst()
    }

}
