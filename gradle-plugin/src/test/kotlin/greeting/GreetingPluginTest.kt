package greeting

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GreetingPluginTest {

    @Test
    fun greeterPluginAddsGreetingTaskToProject() {
        // GIVEN
        val project = ProjectBuilder.builder()
            .build();

        // WHEN
        project.pluginManager.apply("greeting")

        // THEN
        assertTrue(project.tasks.getByName("greet") is GreetingToFileTask)
    }

}
