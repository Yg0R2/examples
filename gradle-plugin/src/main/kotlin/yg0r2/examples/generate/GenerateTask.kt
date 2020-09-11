package yg0r2.examples.generate

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateTask : DefaultTask() {

    val fileCount: Property<Int> = project.objects.property(Int::class.java)
        @Input get

    val content: Property<String> = project.objects.property(String::class.java)
        @Input get

    var generatedFileDir: File = project.buildDir
        @OutputDirectory get

    @TaskAction
    fun perform() {
        for (i in 1..fileCount.get()) {
            writeFile(generatedFileDir.resolve("$i.txt"), content.get())
        }
    }

    private fun writeFile(destination: File, content: String) {
        destination.writeText(content)
    }

}
