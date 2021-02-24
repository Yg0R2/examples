package yg0r2.examples.configurers.structure

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration
import yg0r2.examples.model.Projects

object WebProjectStructureConfigurer: ProjectStructureConfigurer {

    override fun configure(webProject: Project, projects: Projects) {
        webProject.dependencies.apply {
            projects.apiProject?.let { addToConfiguration("api", it) }
        }
    }

}
