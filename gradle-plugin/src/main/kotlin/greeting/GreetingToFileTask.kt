package greeting

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GreetingToFileTask : DefaultTask() {

    var destinationFile: Any? = null

    @OutputFile
    fun getDestinationFile(): File {
        return project.file(destinationFile!!)
    }

    @TaskAction
    fun greet() {
        val file = getDestinationFile()
        file.parentFile.mkdirs()
        file.writeText("Hello!")
    }

}
