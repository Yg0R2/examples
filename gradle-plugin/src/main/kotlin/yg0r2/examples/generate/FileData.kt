package yg0r2.examples.generate

import org.gradle.api.tasks.Input

class FileData {

    var fileCount: Int = 0
        @Input get

    var content: String = ""
        @Input get

}