package yg0r2.examples.configurer.structure

import org.gradle.api.Project
import yg0r2.examples.configurer.Configurer
import yg0r2.examples.model.Projects

interface ProjectStructureConfigurer: Configurer {

    override fun configure(project: Project) {
        configure(project, Projects(project))
    }

    fun configure(project: Project, projects: Projects)

}
