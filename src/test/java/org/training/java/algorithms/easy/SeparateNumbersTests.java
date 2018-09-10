package org.training.java.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        final String value = null;
        assertThrows(IllegalArgumentException.class,
                () -> SeparateNumbers.separateNumbers(value)
        );

        String otherValue = "";
        assertThrows(IllegalArgumentException.class,
                () -> SeparateNumbers.separateNumbers(otherValue)
        );

        String lastValue = "abcd";
        assertThrows(IllegalArgumentException.class,
                () -> SeparateNumbers.separateNumbers(lastValue)
        );

    }

    @Test
    @DisplayName("return YES for 'single-digit' beautiful strings")
    void returnYESForSingleDigitBeautifulStrings() {
        assertEquals("YES 1", SeparateNumbers.separateNumbers("1234"));
        assertEquals("YES 4", SeparateNumbers.separateNumbers("4567"));
        assertEquals("YES 7", SeparateNumbers.separateNumbers("789"));
        assertEquals("YES 2", SeparateNumbers.separateNumbers("23456789"));
    }
}
