package yg0r2.examples

import org.gradle.api.Plugin
import org.gradle.api.Project
import yg0r2.examples.configurer.dependency.ApiProjectDependencyConfigurer
import yg0r2.examples.configurer.dependency.RootProjectProjectDependencyConfigurer
import yg0r2.examples.configurer.dependency.WebProjectDependencyConfigurer
import yg0r2.examples.configurer.plugin.MavenPublishPluginConfigurer
import yg0r2.examples.configurer.structure.ClientProjectStructureConfigurer
import yg0r2.examples.configurer.structure.RootProjectStructureConfigurer
import yg0r2.examples.configurer.structure.WebProjectStructureConfigurer
import yg0r2.examples.configurer.type.GradleProjectConfigurer
import yg0r2.examples.configurer.type.NpmProjectTypeConfigurer
import yg0r2.examples.extensions.*
import yg0r2.examples.model.Projects

class ExamplesPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        val projects = Projects(project)

        projects.rootProject
            .isRequired()
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withStructureConfigurer(RootProjectStructureConfigurer, projects)
            .withDependencyConfigurer(RootProjectProjectDependencyConfigurer)

        projects.apiProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withPluginConfigurers(MavenPublishPluginConfigurer)
            .withDependencyConfigurer(ApiProjectDependencyConfigurer)

        projects.clientProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withPluginConfigurers(MavenPublishPluginConfigurer)
            .withStructureConfigurer(ClientProjectStructureConfigurer, projects)

        projects.uiProject
            .withProjectTypeConfigurer(NpmProjectTypeConfigurer)

        projects.webProject
            .withProjectTypeConfigurer(GradleProjectConfigurer)
            .withStructureConfigurer(WebProjectStructureConfigurer, projects)
            .withPluginConfigurers(MavenPublishPluginConfigurer)
            .withDependencyConfigurer(WebProjectDependencyConfigurer)
    }

}
