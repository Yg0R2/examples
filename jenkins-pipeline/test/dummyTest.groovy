import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class dummyTest extends BasePipelineTest {

    def underTest

    @BeforeEach
    void setUp() {
        super.setUp()

        underTest = loadScript("vars/dummy.groovy")
    }

    @Test
    void test() {
        underTest.call()
        //callStackDump()
        printCallStack()
    }

}