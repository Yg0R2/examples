package yg0r2.examples.maven.plugin

import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.Execute
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.codehaus.plexus.util.cli.CommandLineUtils
import org.codehaus.plexus.util.cli.Commandline

@Mojo(aggregator = true, name = "aggregate", threadSafe = true)
@Execute(phase = LifecyclePhase.COMPILE)
class AggregateMojo: AbstractExamplesMojo() {

    override fun execute() {
        if (project.packaging != "pom") {
            log.info("Skip aggregate goal.")

            return
        }

        val cmd = Commandline()
        cmd.executable = "mvn"
        cmd.addArguments(arrayOf("examples:examples"))

        cmd.workingDirectory = project.basedir

        val out = CommandLineUtils.StringStreamConsumer()
        val error = CommandLineUtils.StringStreamConsumer()

        val exitCode = CommandLineUtils.executeCommandLine(cmd, out, error)

        if (exitCode != 0) {
            throw MojoExecutionException(out.output)
        }

        log.info(out.output)
    }

}
