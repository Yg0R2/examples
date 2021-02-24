package yg0r2.examples.configurers.dependency

import org.gradle.api.Project
import yg0r2.examples.extensions.addToConfiguration

object WebProjectDependencyConfigurer: ProjectDependencyConfigurer {

    override fun configure(project: Project) {
        project.dependencies.apply {
            addToConfiguration("api", "org.springframework.boot:spring-boot-starter-data-redis")
            addToConfiguration("api", "org.springframework.boot:spring-boot-starter-security")
            addToConfiguration("api", "org.springframework.boot:spring-boot-starter-thymeleaf")
            addToConfiguration("api", "org.springframework.boot:spring-boot-starter-web")
        }
    }

}
