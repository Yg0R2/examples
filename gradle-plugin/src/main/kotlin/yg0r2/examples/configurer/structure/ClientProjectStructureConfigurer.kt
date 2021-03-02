package yg0r2.examples.configurer.structure

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration
import yg0r2.examples.extensions.isRequired
import yg0r2.examples.model.Projects

object ClientProjectStructureConfigurer: ProjectStructureConfigurer {

    override fun configure(project: Project, projects: Projects) {
        project.dependencies.apply {
            projects.apiProject
                .isRequired()
                .let { addToConfiguration("api", it) }
        }
    }

}
