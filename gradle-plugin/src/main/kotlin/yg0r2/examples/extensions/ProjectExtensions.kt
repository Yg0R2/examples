package yg0r2.examples.extensions

import org.gradle.api.Project
import yg0r2.examples.configurer.dependency.ProjectDependencyConfigurer
import yg0r2.examples.configurer.plugin.PluginConfigurer
import yg0r2.examples.configurer.structure.ProjectStructureConfigurer
import yg0r2.examples.configurer.type.ProjectTypeConfigurer
import yg0r2.examples.model.Projects

fun Project?.isRequired(): Project {
    return this ?: throw IllegalStateException("Project is required.")
}

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
