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

    @Test
    @DisplayName("should return 7, 1 and 4 as minimal costs for example cases")
    void shouldReturnAppropriateMinimalCostForExampleCases() {
        int[][] matrix = {{5, 3, 4},
                          {1, 5, 8},
                          {6, 4, 2}};
        int cost = MagicSquare.formingMagicSquare(matrix);
        assertEquals(7, cost);

        matrix = new int[][]{
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 5}};
        cost = MagicSquare.formingMagicSquare(matrix);
        assertEquals(1, cost);

        matrix = new int[][]{
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}};
        cost = MagicSquare.formingMagicSquare(matrix);
        assertEquals(4, cost);
    }

    @Test
    @DisplayName("should return 0 as minimal cost for magic square input")
    void shouldReturnZeroAsMinimalCostForMagicSquare() {
        int[][] matrix = {{8, 3, 4},
                {1, 5, 9},
                {6, 7, 2}};
        int cost = MagicSquare.formingMagicSquare(matrix);
        assertEquals(0, cost);
    }


}
