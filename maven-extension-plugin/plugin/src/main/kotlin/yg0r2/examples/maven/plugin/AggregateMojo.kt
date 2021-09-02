package yg0r2.examples.maven.plugin

import org.apache.maven.plugins.annotations.Execute
import org.apache.maven.plugins.annotations.Mojo

@Mojo(aggregator = true, name = "aggregate", threadSafe = true)
@Execute(goal = "examples")
class AggregateMojo: AbstractExamplesMojo() {

    override fun execute() {
        if (project.packaging != "pom") {
            log.info("Skip aggregate goal.")

            return
        }
    }

}
