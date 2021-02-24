package yg0r2.examples.configurers.dependency

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration

object ApiProjectDependencyConfigurer: ProjectDependencyConfigurer {

    override fun configure(project: Project) {
        project.dependencies.apply {
            addToConfiguration("api", "javax.validation:validation-api:+")

            addToConfiguration("implementation", "com.fasterxml.jackson.core:jackson-annotations:+")
            addToConfiguration("implementation", "com.fasterxml.jackson.core:jackson-databind:+")
            addToConfiguration("implementation", "org.apache.commons:commons-lang3:+")
        }
    }

}
