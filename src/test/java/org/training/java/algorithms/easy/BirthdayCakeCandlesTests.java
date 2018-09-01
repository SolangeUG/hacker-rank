package org.training.java.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the birthday cake candles challenge.
 * @author Solange U. Gasengayire
 */
@DisplayName("Birthday Cake Candles should")
class BirthdayCakeCandlesTests {

    @Test
    @DisplayName("make sure input array values are positive integers")
    void makeSureInputArrayValuesArePositiveIntegers() {
        int[] heights = {4, 1, 2, -2};
        int result = BirthdayCakeCandles.birthdayCakeCandles(heights);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("make sure input array values are within bounds")
    void makeSureInputArrayValuesAreWithinBounds() {
        int[] heights = {4, 1, 2, Integer.MAX_VALUE};
        int result = BirthdayCakeCandles.birthdayCakeCandles(heights);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("make sure input array is not empty")
    void makeSureInputArrayIsNotEmpty() {
        int[] heights = {};
        int result = BirthdayCakeCandles.birthdayCakeCandles(heights);
        assertEquals(-1, result);
    }


    @Test
    @DisplayName("return 1 when input values are all unique")
    void returnOneWhenInputValuesAreUnique() {
        int[] heights = {1, 2, 4, 8};
        int result = BirthdayCakeCandles.birthdayCakeCandles(heights);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("return count of highest value when it's duplicated in input array")
    void returnCountOfHighestValueWhenDuplicatedInInputArray() {
        int[] heights = {1, 2, 4, 8, 1, 4, 8};
        int result = BirthdayCakeCandles.birthdayCakeCandles(heights);
        assertEquals(2, result);

        int[] otherHeights = {8, 8, 8, 8};
        result = BirthdayCakeCandles.birthdayCakeCandles(otherHeights);
        assertEquals(4, result);
    }


}
