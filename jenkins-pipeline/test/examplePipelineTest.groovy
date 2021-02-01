import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class examplePipelineTest extends DeclarativePipelineTest {

    def underTest

    @BeforeEach
    void setUp() {
        scriptRoots = ['src', 'vars']

        super.setUp()

        helper.registerAllowedMethod('dummyStep', [String.class], {
            param -> loadScript('dummyStep.groovy').call(param)
        })

        underTest = loadScript("examplePipeline.groovy")
    }

    @Test
    void test() {
        underTest.call()

        printCallStack()
    }

}