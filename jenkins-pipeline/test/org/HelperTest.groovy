package org


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HelperTest {

    private Helper underTest

    @BeforeEach
    void setUp() {
        underTest = new Helper()
    }

    @Test
    void test_instanceMethod() {
        underTest.instanceMethod()
    }

    @Test
    void test_staticMethod() {
        Helper.staticMethod()
    }

}
