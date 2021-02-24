package yg0r2.examples

import org.gradle.api.Plugin
import org.gradle.api.Project
import yg0r2.examples.configurers.dependency.ApiProjectDependencyConfigurer
import yg0r2.examples.configurers.type.GradleProjectConfigurer
import yg0r2.examples.configurers.dependency.RootProjectProjectDependencyConfigurer
import yg0r2.examples.configurers.dependency.WebProjectDependencyConfigurer
import yg0r2.examples.configurers.plugin.MavenPublishPluginConfigurer
import yg0r2.examples.configurers.structure.RootProjectStructureConfigurer
import yg0r2.examples.configurers.structure.WebProjectStructureConfigurer
import yg0r2.examples.extensions.withDependencyConfigurer
import yg0r2.examples.extensions.withPluginConfigurers
import yg0r2.examples.extensions.withProjectTypeConfigurer
import yg0r2.examples.extensions.withStructureConfigurer
import yg0r2.examples.model.Projects

class ExamplesPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        val projects = Projects(project)

        projects.rootProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withStructureConfigurer(RootProjectStructureConfigurer, projects)
            .withDependencyConfigurer(RootProjectProjectDependencyConfigurer)

        projects.apiProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withPluginConfigurers(MavenPublishPluginConfigurer)
            .withDependencyConfigurer(ApiProjectDependencyConfigurer)

        projects.webProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withStructureConfigurer(WebProjectStructureConfigurer, projects)
            .withPluginConfigurers(MavenPublishPluginConfigurer)
            .withDependencyConfigurer(WebProjectDependencyConfigurer)
    }

}
