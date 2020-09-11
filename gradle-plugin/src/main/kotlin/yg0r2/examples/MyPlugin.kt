package yg0r2.examples

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.DependencySet
import org.gradle.api.plugins.JavaPlugin
import org.gradle.kotlin.dsl.add
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import yg0r2.examples.generate.FileDataExtension
import yg0r2.examples.generate.GenerateTask

class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // Depending on other plugin
        project.plugins.apply(SpringBootPlugin::class.java)
        project.plugins.apply(DependencyManagementPlugin::class.java)
        project.plugins.apply(JavaPlugin::class.java)

        // Execute in case of JavaPlugin present
        val javaPluginAction = Action<JavaPlugin> {
            println("Jee JavaPlugin found :)")
        }
        project.plugins.withType(JavaPlugin::class.java, javaPluginAction)

        // Add project dependencies
        val configuration = project.configurations.getByName("implementation")
        configuration.defaultDependencies {
            addAll(listOf(
                project.dependencies.create("org.springframework.boot:spring-boot-starter-data-redis"),
                project.dependencies.create("org.springframework.boot:spring-boot-starter-security"),
                project.dependencies.create("org.springframework.boot:spring-boot-starter-thymeleaf"),
                project.dependencies.create("org.springframework.boot:spring-boot-starter-web"),
                project.dependencies.create("org.springframework.session:spring-session-data-redis")
            ))
        }

        val fileDataExtension = project.extensions.create("fileData", FileDataExtension::class.java, project)
        project.tasks.register("generate", GenerateTask::class.java) {
            content.set(fileDataExtension.content)
            fileCount.set(fileDataExtension.fileCount)
        }
    }

}