package yg0r2.examples.configure

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.create

class MavenPublishConfiguration(private val project: Project) {

    fun apply() {
        project.plugins.apply {
            apply(MavenPublishPlugin::class.java)
        }

        project.extensions.getByType(JavaPluginExtension::class.java).apply {
            withSourcesJar()
        }

        project.extensions.getByType(PublishingExtension::class.java).apply {
            publications {
                create<MavenPublication>("maven") {
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
            }
        }
    }

}