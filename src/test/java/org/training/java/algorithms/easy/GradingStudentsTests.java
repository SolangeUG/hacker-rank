package org.training.java.algorithms.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    @DisplayName("not round grades that are lower than 38")
    void notRoundGradesLowerThanThirtyEight() {
        int[] grades = {5, 10, 15, 37};
        int[] results = GradingStudents.gradingStudents(grades);
        assertAll("return unrounded grades for example case {5, 10, 15, 37}",
                () -> assertEquals(4, results.length),
                () -> assertEquals(5, results[0]),
                () -> assertEquals(10, results[1]),
                () -> assertEquals(15, results[2]),
                () -> assertEquals(37, results[3])
        );
    }

    @Test
    @DisplayName("not round grades whose difference with the next five multiple is higher than 3")
    void notRoundGradesWhoseDifferenceWithNextFiveMultipleIsHigherThanThree() {
        int[] grades = {40, 51, 66, 87};
        int[] results = GradingStudents.gradingStudents(grades);
        assertAll("return unrounded grades for example case {40, 51, 66, 87}",
                () -> assertEquals(4, results.length),
                () -> assertEquals(40, results[0]),
                () -> assertEquals(51, results[1]),
                () -> assertEquals(66, results[2]),
                () -> assertEquals(87, results[3])
        );
    }
}
