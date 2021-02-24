package yg0r2.examples.configurers.plugin

import org.gradle.api.Project

interface PluginConfigurer {

    fun configure(project: Project)

}
