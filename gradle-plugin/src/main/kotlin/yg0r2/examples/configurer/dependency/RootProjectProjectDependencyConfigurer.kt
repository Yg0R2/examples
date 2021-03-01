package yg0r2.examples.configurer.dependency

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration

object RootProjectProjectDependencyConfigurer: ProjectDependencyConfigurer {

    override fun configure(project: Project) {
        project.dependencies.apply {
            addToConfiguration("api", "org.springframework.session:spring-session-data-redis")

            addToConfiguration("testImplementation", "org.springframework.boot:spring-boot-starter-test")
        }
    }

}
