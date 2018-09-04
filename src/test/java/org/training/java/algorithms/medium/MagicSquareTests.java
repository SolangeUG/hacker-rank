package org.training.java.algorithms.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("make sure resulting magic square only contains unique values")
    void makeSureResultValuesAreUnique() {
        int[][] matrix = {{5, 3, 4},
                          {1, 5, 8},
                          {6, 4, 2}};
        int cost = MagicSquare.formingMagicSquare(matrix);
        int[][] magicSquare = MagicSquare.magicSquare;
        assertTrue(cost > -1);

        List<Integer> values = new ArrayList<>();
        for (int[] row : magicSquare) {
            for (int element : row) {
                assertTrue(! values.contains(element));
                values.add(element);
            }
        }
    }


}
