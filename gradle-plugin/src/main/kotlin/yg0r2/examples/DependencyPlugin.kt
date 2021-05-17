package yg0r2.examples

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension
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
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar
import yg0r2.examples.configure.DependencyConfiguration
import yg0r2.examples.configure.MavenPublishConfiguration
import java.util.*

class DependencyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // Depending on other plugin
        project.allprojects.forEach {
            it.group = "yg0r2.examples"

            if (it.name.endsWith("ui")) {
                return@forEach
            }

            it.plugins.apply {
                apply(DependencyManagementPlugin::class.java)
                apply(JavaLibraryPlugin::class.java)
                apply(SpringBootPlugin::class.java)
            }

            it.repositories.addAll(listOf(
                project.repositories.mavenLocal(),
                project.repositories.mavenCentral()
            ))

            it.configure<StandardDependencyManagementExtension> {
                imports {
                    mavenBom("org.springframework.cloud:spring-cloud-dependencies:+")
                }
            }
        }

        project.subprojects.forEach {
            if (it.name.endsWith("ui")) {
                return@forEach
            }

            MavenPublishConfiguration(it).apply()

            it.tasks.named("bootBuildImage", BootBuildImage::class.java) {
                enabled = false
            }

            it.tasks.named("bootJar", BootJar::class.java) {
                enabled = false
            }

            it.tasks.named("jar", Jar::class.java) {
                enabled = true
            }
        }

        // Execute in case of JavaPlugin present
        val javaPluginAction = Action<JavaPlugin> {
            println("Jee JavaPlugin found :)")
        }
        project.plugins.withType(JavaPlugin::class.java, javaPluginAction)

        // Add project dependencies
        DependencyConfiguration(project).apply()

        project.tasks.named("test", Test::class.java) {
            useJUnitPlatform()
        }

        project.configure<JavaPluginConvention> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

}
