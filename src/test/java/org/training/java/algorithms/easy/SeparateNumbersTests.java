package org.training.java.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the separate the numbers challenge.
 * @author Solange U. Gasengayire
 */
@DisplayName("Separate The Numbers should")
class SeparateNumbersTests {

    @Test
    @DisplayName("make sure input string is not empty")
    void makeSureInputStringIsNotEmpty() {
        String value = "";
        assertThrows(IllegalArgumentException.class,
                () -> SeparateNumbers.separateNumbers(value)
        );
    }
}
