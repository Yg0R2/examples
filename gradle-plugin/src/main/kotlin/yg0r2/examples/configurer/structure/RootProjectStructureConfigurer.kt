package yg0r2.examples.configurer.structure

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration
import yg0r2.examples.model.Projects

object RootProjectStructureConfigurer: ProjectStructureConfigurer {

    override fun configure(project: Project, projects: Projects) {
        project.dependencies.apply {
            projects.webProject?.let { addToConfiguration("api", it) }
        }
    }

}
