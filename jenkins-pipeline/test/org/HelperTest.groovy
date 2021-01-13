package org

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HelperTest {

    def underTest

    @BeforeEach
    void setUp() {
        underTest = new Helper()
    }

    @Test
    void testAsd() {
        underTest.asd()
    }

}
