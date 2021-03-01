package yg0r2.examples.configurer.plugin

import org.gradle.api.Project

interface PluginConfigurer {

    fun configure(project: Project)

}
