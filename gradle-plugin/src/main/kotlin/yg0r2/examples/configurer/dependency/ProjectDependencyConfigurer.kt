package yg0r2.examples.configurer.dependency

import org.gradle.api.Project

interface ProjectDependencyConfigurer {

    fun configure(project: Project)

}