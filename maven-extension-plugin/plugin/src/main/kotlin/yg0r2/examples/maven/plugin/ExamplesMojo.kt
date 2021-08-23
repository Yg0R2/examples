package yg0r2.examples.maven.plugin

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.Mojo

@Mojo(name = "examples")
class ExamplesMojo: AbstractMojo() {

    override fun execute() {
        log.info("hello from: ExamplesMojo")
    }

}
