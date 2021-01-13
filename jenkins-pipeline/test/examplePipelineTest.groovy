import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.cps.BasePipelineTestCPS
import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.apache.groovy.test.ScriptTestAdapter
import org.junit.Before
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

//class examplePipelineTest extends BasePipelineTestCPS {
//class examplePipelineTest extends BasePipelineTest {
class examplePipelineTest extends DeclarativePipelineTest {

    def underTest

    @BeforeEach
    void setUp() {
        super.setUp()

        underTest = loadScript("vars/examplePipeline.groovy")
    }

    @Test
    void test() {
        underTest.call()
        printCallStack()
    }

}