package yg0r2.examples.model

import org.gradle.api.Project

data class Projects(private val project: Project) {

    val rootProject: Project = project.rootProject

    val apiProject: Project? = getSubproject("api")
    val clientProject: Project? = getSubproject("client")
    val uiProject: Project? = getSubproject("ui")
    val webProject: Project? = getSubproject("web")

    private fun getSubproject(subprojectName: String) = project.subprojects.find { it.name.endsWith("-$subprojectName") }

}
