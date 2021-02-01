package org

import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.MethodCall
import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class DummyStepTest extends DeclarativePipelineTest {

    private DummyStep underTest

    @BeforeEach
    void setUp() {
        super.setUp()

        underTest = new DummyStep(binding.variables)
    }

    @Test
    void test_greet() {
        // GIVEN
//        def echo = Mockito.mock(Script)
//        Mockito.doNothing().when(echo).call(ArgumentMatchers.anyString())
//        binding.setVariable('echo', echo)

//        binding.setVariable('echo', { param -> helper.callStack.add(param) })

        // WHEN
        // THEN
        underTest.greet('World')

        printCallStack()
    }

}
