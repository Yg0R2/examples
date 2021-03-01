package yg0r2.examples.configurer.type

import org.gradle.api.Project

interface ProjectTypeConfigurer {

    fun configure(project: Project)

}