package org.training.java.algorithms.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the magic square challenge
 * @author Solange U. Gasengayire
 */
@DisplayName("Magic Square should")
class MagicSquareTests {

    @Test
    @DisplayName("make sure input parameters are within the [1, 9] range")
    void makeSureInputParametersArePositiveIntegers() {
        int[][] matrix = {{-3, 2, -9},
                          {4, 24, 12},
                          {-3, 12, 9}};
        int cost = MagicSquare.formingMagicSquare(matrix);
        assertEquals(-1, cost);
    }


}
