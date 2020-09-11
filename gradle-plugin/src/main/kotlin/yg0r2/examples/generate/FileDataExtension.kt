package yg0r2.examples.generate

import org.gradle.api.Action

open class FileDataExtension {

    val fileData: FileData = FileData()

    fun fileData(action: Action<in FileData>) {
        action.execute(fileData)
    }

}