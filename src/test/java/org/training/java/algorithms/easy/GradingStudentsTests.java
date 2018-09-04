package org.training.java.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the grading students challenge.
 * @author Solange U. Gasengayire
 */
@DisplayName("Grading Students Should")
class GradingStudentsTests {

    @Test
    @DisplayName("make sure input array values are positive integers")
    void makeSureInputArrayValuesArePositiveIntegers() {
        int[] grades = {-15, 0, 5, 20, 85};
        int[] results = GradingStudents.gradingStudents(grades);
        assertEquals(0, results.length);
    }

    @Test
    @DisplayName("make sure input array values are within bounds")
    void makeSureInputArrayValuesAreWithinBounds() {
        int[] grades = {5, 10, 15, 20, 185, 200};
        int[] results = GradingStudents.gradingStudents(grades);
        assertEquals(0, results.length);
    }
}
