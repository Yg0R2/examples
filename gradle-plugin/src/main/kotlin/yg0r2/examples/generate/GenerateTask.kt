package yg0r2.examples.generate

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateTask : DefaultTask() {

    var fileCount: Int = 0
        @Input get

    var content: String = ""
        @Input get

    var generatedFileDir: File = project.buildDir
        @OutputDirectory get

    @TaskAction
    fun perform() {
        for (i in 0..fileCount) {
            writeFile(generatedFileDir.resolve("$i.txt"), content)
        }
    }

    private fun writeFile(destination: File, content: String) {
        destination.writeText(content)
    }

}
