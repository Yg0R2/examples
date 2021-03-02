package yg0r2.examples.configurer

import org.gradle.api.Project

interface Configurer {

    fun configure(project: Project)

}
