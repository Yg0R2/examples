package yg0r2.examples.maven.extension

import org.apache.maven.AbstractMavenLifecycleParticipant
import org.apache.maven.execution.MavenSession
import org.codehaus.plexus.component.annotations.Component

@Component(role = AbstractMavenLifecycleParticipant::class, hint = "examples")
class ExamplesMavenLifecycleParticipant: AbstractMavenLifecycleParticipant() {

    override fun afterProjectsRead(session: MavenSession?) {
        println("hello from: afterProjectsRead")
    }

    override fun afterSessionEnd(session: MavenSession?) {
        println("hello from: afterSessionEnd")
    }

    override fun afterSessionStart(session: MavenSession?) {
        println("hello from: afterSessionStart")
    }

}
