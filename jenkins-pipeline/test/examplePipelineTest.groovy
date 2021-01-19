import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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