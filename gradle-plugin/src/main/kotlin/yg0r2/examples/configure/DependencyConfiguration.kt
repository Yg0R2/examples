package yg0r2.examples.configure

import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.exclude

class DependencyConfiguration(private val project: Project) {

    private val apiProject: Project? = getSubProject(project.subprojects, "api")
    private val clientProject: Project? = getSubProject(project.subprojects, "client")
    private val daoProject: Project? = getSubProject(project.subprojects, "dao")
    private val serviceProject: Project? = getSubProject(project.subprojects, "service")
    private val webProject: Project? = getSubProject(project.subprojects, "web")

    fun apply() {
        apiProject?.let {
            getDependencySet(it, "api").apply {
                add(it.dependencies.create("javax.validation", "validation-api", "+"))
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("com.fasterxml.jackson.core", "jackson-annotations", "+"))
                add(it.dependencies.create("com.fasterxml.jackson.core", "jackson-databind", "+"))
                add(it.dependencies.create("org.apache.commons", "commons-lang3", "+"))
            }
        }

        clientProject?.let {
            it.plugins.apply {
                apply(MavenPublishPlugin::class.java)
            }

            getDependencySet(it, "api").apply {
                apiProject?.let { _project -> add(it.dependencies.create(_project)) }
            }
        }

        daoProject?.let {
            getDependencySet(it, "api").apply {
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-data-jpa"))
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("com.h2database", "h2"))
                add(it.dependencies.create("org.apache.commons", "commons-lang3", "+"))
                add(it.dependencies.create("org.springframework", "spring-context"))
            }
        }

        serviceProject?.let {
            getDependencySet(it, "api").apply {
                apiProject?.let { _project -> add(it.dependencies.create(_project)) }
                daoProject?.let { _project -> add(it.dependencies.create(_project)) }
            }

            getDependencySet(it).apply {
                add(it.dependencies.create("org.springframework.security", "spring-security-core"))
            }
        }

        webProject?.let {
            getDependencySet(it, "api").apply {
                serviceProject?.let { _project -> add(it.dependencies.create(_project)) }

                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-data-redis"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-security"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-thymeleaf"))
                add(it.dependencies.create("org.springframework.boot", "spring-boot-starter-web"))
            }
        }

        project.also {
            getDependencySet(it, "api").apply {
                webProject?.let { _project -> add(it.dependencies.create(_project)) }

                add(it.dependencies.create("org.springframework.session", "spring-session-data-redis"))
            }

            getDependencySet(it, "testImplementation").apply {
                add(it.dependencies.create("org.springframework.boot:spring-boot-starter-test"))
            }
        }

        // Excluding dependency https://docs.gradle.org/current/userguide/resolution_rules.html
        project.configurations.all {
            exclude("org.junit.vintage", "junit-vintage-engine")
        }

        // Gradle automatically use `junit-jupiter` from any (transitive) dependencies instead of `junit`
//        project.dependencies.modules {
//            module("junit:junit") {
//                replacedBy("org.junit.jupiter:junit-jupiter", "junit is deprecated, have to use junit-jupiter")
//            }
//        }
    }

    private fun getDependencySet(it: Project, name: String = "implementation") = it.configurations.getByName(name).dependencies

    private fun getSubProject(subProjects: Set<Project>, name: String): Project? {
        return subProjects.firstOrNull { it.name.endsWith(name) }
    }

}
