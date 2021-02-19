package generate

import GradlePluginConstants
import org.gradle.api.Plugin
import org.gradle.api.Project
import yg0r2.examples.generate.FileDataExtension
import yg0r2.examples.generate.GenerateTask

class GenerateFilesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val fileDataExtension = project.extensions.create("fileData", FileDataExtension::class.java, project)
        project.tasks.register("generate", GenerateTask::class.java) {
            group = GradlePluginConstants.TASK_GROUP

            content.set(fileDataExtension.content)
            fileCount.set(fileDataExtension.fileCount)
        }
    }

}
