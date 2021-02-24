package yg0r2.examples.extensions

import org.gradle.api.Project
import yg0r2.examples.configurers.dependency.ProjectDependencyConfigurer
import yg0r2.examples.configurers.plugin.PluginConfigurer
import yg0r2.examples.configurers.structure.ProjectStructureConfigurer
import yg0r2.examples.configurers.type.ProjectTypeConfigurer
import yg0r2.examples.model.Projects

fun Project?.withDependencyConfigurer(configurer: ProjectDependencyConfigurer): Project? {
    this?.let {
        configurer.configure(it)
    }

    return this
}

fun Project?.withPluginConfigurers(vararg configurers: PluginConfigurer): Project? {
    this?.let {
        configurers.forEach { _configurer ->
            _configurer.configure(it)
        }
    }

    return this
}

fun Project?.withProjectTypeConfigurer(configurer: ProjectTypeConfigurer): Project? {
    this?.let {
        configurer.configure(it)
    }

    return this
}

fun Project?.withStructureConfigurer(configurer: ProjectStructureConfigurer, projects: Projects): Project? {
    this?.let {
        configurer.configure(it, projects)
    }

    return this
}
