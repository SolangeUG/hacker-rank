package org.training.java.algorithms.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the climbing the leaderboard challenge
 * @author Solange U. Gasengayire
 */
@DisplayName("Climbing The Leaderboard should")
class ClimbingTheLeaderboardTests {

    @Test
    @DisplayName("make sure input parameters are positive")
    void makeSureInputParametersArePositiveIntegers() {
        int[] scores = {80, 120, 0, -5};
        int[] aliceScores = {40, 100};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{120, 80, 70, 50};
        aliceScores = new int[]{-10, 0, 15};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("make sure input parameters are within bounds")
    void makeSureInputParametersAreWithinBounds() {
        int[] scores = {Integer.MAX_VALUE, 120, 80, 20};
        int[] aliceScores = {40, 100};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{120, 80, 70, Integer.MIN_VALUE};
        aliceScores = new int[]{0, 15, Integer.MAX_VALUE};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("return {1} when Alice only score is higher than anyone else's")
    void returnFirstPlaceWhenAliceScoresBest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {90};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(1, results.length);
        assertEquals(1, results[0]);
    }

    @Test
    @DisplayName("return {6} when Alice only score is lower than anyone else's")
    void returnLastPlaceWhenAliceScoresLowest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {5};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(1, results.length);
        assertEquals(6, results[0]);

        scores = new int[]{80, 50, 40, 20, 10};
        results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(1, results.length);
        assertEquals(6, results[0]);

        scores = new int[]{80, 50, 40, 40, 20, 10, 10};
        results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(1, results.length);
        assertEquals(6, results[0]);
    }

    @Test
    @DisplayName("return {6, 4, 1} when Alice scores lowest, middle then highest than anyone else")
    void returnFirstAndLastPositionsWhenAliceScoresHighestThenLowest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {5, 30, 90};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(3, results.length);
        assertEquals(6, results[0]);
        assertEquals(4, results[1]);
        assertEquals(1, results[2]);
    }

    @Test
    @DisplayName("return {6, 1} when Alice first scores lowest then highest than anyone else")
    void returnLastAndFirstPositionsWhenAliceScoresLowestThenHighest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {5, 90};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(2, results.length);
        assertEquals(6, results[0]);
        assertEquals(1, results[1]);
    }

    @Test
    @DisplayName("return {6, 4, 2, 1} for scores = {100, 100, 50, 40, 40, 20, 10} and alice = {5, 25, 50, 120}")
    void returnAppropriateLeaderboardArrayForExampleCase() {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertAll("return {6, 4, 2, 1} for example case",
                    () -> assertEquals(4, results.length),
                    () -> assertEquals(6, results[0]),
                    () -> assertEquals(4, results[1]),
                    () -> assertEquals(2, results[2]),
                    () -> assertEquals(1, results[3])
        );
    }


}
