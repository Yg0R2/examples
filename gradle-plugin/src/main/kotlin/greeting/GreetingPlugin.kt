package greeting

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

class GreetingPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("greeting", GreetingPluginExtension::class.java)

        project.task("hello") {
            group = "examples"

            doLast {
                println("${extension.message} from ${extension.greeter}")
            }
        }

        project.tasks.register("greet", GreetingToFileTask::class.java) {
            group = "examples"

            destinationFile = {
                project.extra["greetingFile"]!!
            }
        }

        project.tasks.register("sayGreeting") {
            dependsOn("greet")
            doLast {
                println(project.file(project.extra["greetingFile"]!!).readText())
            }
        }
    }

}
