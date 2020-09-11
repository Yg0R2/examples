package yg0r2.examples.generate

import org.gradle.api.Project
import org.gradle.api.provider.Property

open class FileDataExtension(project: Project) {

    val fileCount: Property<Int> = project.objects.property(Int::class.java)

    val content: Property<String> = project.objects.property(String::class.java)

}