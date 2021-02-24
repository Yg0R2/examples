package yg0r2.examples.configurers.type

import org.gradle.api.Project

interface ProjectTypeConfigurer {

    fun configure(project: Project)

}