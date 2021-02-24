package yg0r2.examples.configurers.structure

import org.gradle.api.Project
import yg0r2.examples.model.Projects

interface ProjectStructureConfigurer {

    fun configure(project: Project, projects: Projects)

}