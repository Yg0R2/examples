package org.examples.queens.smarttable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TableUtilsTest {

    @CsvSource(value = {
        "4, 2, true",
        "4, 4, false"
    })
    @ParameterizedTest(name = "New Queen 'canPlace' on [{0}:{1}]")
    void canPlace(int x, int y, boolean expected) {
        // GIVEN
        boolean[][] board = new boolean[][] {
            new boolean[] {false, false, false, false, false, true, false, false, false},
            new boolean[] {false, true, false, false, false, false, false, false, false},
            new boolean[] {false, false, false, false, false, false, false, false, false},
            new boolean[] {false, false, false, false, false, false, false, false, false},
            new boolean[] {false, false, false, false, false, false, false, false, false},
            new boolean[] {false, false, false, false, false, false, false, true, false},
            new boolean[] {false, false, false, false, false, false, false, false, false},
            new boolean[] {false, false, false, false, false, false, false, false, true}
        };

        // WHEN
        boolean actual = TableUtils.canPlace(board, x, y);

        // THEN
        assertThat(actual)
            .as("New Queen 'canPlace' on [%s:%s]", x, y)
            .isEqualTo(expected);
    }

}