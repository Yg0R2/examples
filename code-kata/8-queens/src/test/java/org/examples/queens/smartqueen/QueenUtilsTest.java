package org.examples.queens.smartqueen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QueenUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @CsvSource(value = {
        "0, 0, 0, 7, true",
        "0, 0, 7, 0, true",
        "0, 0, 7, 7, true",
        "7, 7, 0, 0, true",
        "3, 3, 3, 3, true",
        "3, 3, 2, 1, false",
        "3, 3, 1, 2, false",
        "3, 3, 1, 4, false",
        "3, 3, 2, 5, false",
        "3, 3, 4, 1, false",
        "3, 3, 5, 2, false",
        "3, 3, 4, 5, false",
        "3, 3, 5, 4, false",
    })
    @ParameterizedTest(name = "Queen on [{0}:{1}] 'canHit' new Queen on [{2}:{3}], expected: {4}")
    void canHit(int qX, int qY, int x , int y, boolean expected) {
        // GIVEN
        Queen queen = new Queen(qX, qY);

        // WHEN
        boolean actual = QueenUtils.canHit(queen, x, y);

        // THEN
        assertThat(actual)
            .as("%s 'canHit' new Queen on [%s:%s], expected: %s", queen, x, y, expected)
            .isEqualTo(expected);
    }

    @CsvSource(value = {
        "4, 2, true",
        "4, 4, false"
    })
    @ParameterizedTest(name = "New Queen 'canPlace' on [{0}:{1}]")
    void canPlace(int x, int y, boolean expected) {
        // GIVEN
        List<Queen> queens = List.of(new Queen(0, 5), new Queen(1, 1), new Queen(5, 6), new Queen(7, 0));

        // WHEN
        boolean actual = QueenUtils.canPlace(queens, x, y);

        // THEN
        assertThat(actual)
            .as("New Queen 'canPlace' on [%s:%s]", x, y)
            .isEqualTo(expected);
    }

}
