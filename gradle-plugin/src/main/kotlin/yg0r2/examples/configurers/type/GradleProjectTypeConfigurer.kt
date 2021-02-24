package yg0r2.examples.configurers.type

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.repositories
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.bundling.BootJar

object GradleProjectConfigurer: ProjectTypeConfigurer {

    override fun configure(project: Project) {
        project.group = "yg0r2.examples"

        project.repositories {
            mavenLocal()
            mavenCentral()
        }

        project.plugins.apply {
            apply(DependencyManagementPlugin::class.java)
            apply(JavaLibraryPlugin::class.java)
            apply(SpringBootPlugin::class.java)
        }

        project.configure<JavaPluginConvention> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        project.tasks.apply {
            named<Test>("test") {
                useJUnitPlatform()
            }

            if (project != project.rootProject) {
                configureSubProjectsTasks()
            }
        }
    }

    private fun TaskContainer.configureSubProjectsTasks() {
        named<BootBuildImage>("bootBuildImage") {
            isEnabled = false
        }

        named<BootJar>("bootJar") {
            isEnabled = false
        }

        named<Jar>("jar") {
            isEnabled = true
        }
    }

}
