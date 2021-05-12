package yg0r2.examples.configure

import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.credentials

class MavenPublishConfiguration(private val project: Project) {

    companion object {
        const val GITHUB_PACKAGES_ULR: String = "https://maven.pkg.github.com"
        const val GITHUB_PROJECT_NAME: String = "examples"
        const val GITHUB_USER_NAME: String = "Yg0R2"
    }

    private val isRelease: Boolean = !project.version.toString().endsWith("SNAPSHOT")

    fun apply() {
        project.plugins.apply {
            apply(MavenPublishPlugin::class.java)
        }

        project.extensions.getByType(JavaPluginExtension::class.java).apply {
            withSourcesJar()
        }

        project.extensions.getByType(PublishingExtension::class.java).apply {
            publications {
                create<MavenPublication>("github") {
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()

                    from(project.components.getByName("java"))

                    versionMapping {
                        usage("java-api") {
                            fromResolutionOf("runtimeClasspath")
                        }

                        usage("java-runtime") {
                            fromResolutionResult()
                        }
                    }
                }
            }

            repositories {
                mavenLocal()
                if (isRelease) {
                    maven {
                        name = "github"
                        url = project.uri("$GITHUB_PACKAGES_ULR/$GITHUB_USER_NAME/$GITHUB_PROJECT_NAME/${project.rootProject.name}")
                        credentials(PasswordCredentials::class)
                    }
                }
            }
        }
    }

}