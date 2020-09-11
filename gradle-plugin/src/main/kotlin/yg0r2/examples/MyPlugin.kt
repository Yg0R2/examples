package yg0r2.examples

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import yg0r2.examples.generate.FileDataExtension
import yg0r2.examples.generate.GenerateTask

class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // Depending on other plugin
        project.plugins.apply(SpringBootPlugin::class.java)
        project.plugins.apply(DependencyManagementPlugin::class.java)
        project.plugins.apply(JavaPlugin::class.java)

        //project.dependencies.add()

        project.extensions.create("fileData", FileDataExtension::class.java)
        project.tasks.register("generate", GenerateTask::class.java)
    }

}