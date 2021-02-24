package yg0r2.examples.configurers.plugin

import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.credentials

object MavenPublishPluginConfigurer: PluginConfigurer {

    override fun configure(project: Project) {
        project.plugins.apply {
            apply(MavenPublishPlugin::class.java)
        }

        project.extensions.getByType(JavaPluginExtension::class.java).apply {
            withSourcesJar()
        }

        val isRelease: Boolean = !project.version.toString().endsWith("SNAPSHOT")

        project.extensions.getByType(PublishingExtension::class.java).apply {
            if (isRelease) {
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
            }

            repositories {
                mavenLocal()
                if (isRelease) {
                    maven {
                        name = "github"
                        url = project.uri("https://maven.pkg.github.com/Yg0R2/examples")
                        credentials(PasswordCredentials::class)
                    }
                }
            }
        }
    }

}