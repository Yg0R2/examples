package greeting

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

class GreetingPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("greeting", GreetingPluginExtension::class.java)

        project.task("hello") {
            group = GradlePluginConstants.TASK_GROUP

            doLast {
                println("${extension.message} from ${extension.greeter}")
            }
        }

        project.tasks.register("greet", GreetingToFileTask::class.java) {
            group = GradlePluginConstants.TASK_GROUP

            destinationFile = {
                project.extra["greetingFile"]!!
            }
        }

        project.tasks.register("sayGreeting") {
            group = GradlePluginConstants.TASK_GROUP

            dependsOn("greet")
            doLast {
                println(project.file(project.extra["greetingFile"]!!).readText())
            }
        }
    }

}
