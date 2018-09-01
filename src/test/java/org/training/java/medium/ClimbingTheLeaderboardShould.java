package org.training.java.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.training.java.algorithms.medium.ClimbingTheLeaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the climbing the leaderboard challenge
 * @author Solange U. Gasengayire
 */
@DisplayName("Climbing The Leaderboard should")
class ClimbingTheLeaderboardShould {

    @Test
    @DisplayName("make sure input parameters are positive")
    void makeSureInputParametersArePositiveIntegers() {
        int[] scores = {80, 120, 0, -5};
        int[] aliceScores = {100, 40};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{120, 80, 70, 50};
        aliceScores = new int[]{0, 15, -10};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("make sure input parameters are within bounds")
    void makeSureInputParametersAreWithinBounds() {
        int[] scores = {Integer.MAX_VALUE, 120, 80, 20};
        int[] aliceScores = {100, 40};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{120, 80, 70, Integer.MIN_VALUE};
        aliceScores = new int[]{0, 15, Integer.MAX_VALUE};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("should return {1} when Alice only score is higher than anyone else's")
    void returnFirstPlaceWhenAliceScoresBest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {90};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(1, results.length);
        assertEquals(1, results[0]);
    }

    @Test
    @DisplayName("should return {6} when Alice only score is lower than anyone else's")
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
    @DisplayName("should return {1, 6} when Alice first scores highest then lowest than anyone else's")
    void returnFirstAndLastPositionsWhenAliceScoresHighestThenLowest() {
        int[] scores = {80, 80, 50, 40, 20, 20, 10};
        int[] alice = {90, 5};
        int[] results = ClimbingTheLeaderboard.climbingLeaderboard(scores, alice);
        assertEquals(2, results.length);
        assertEquals(1, results[0]);
        assertEquals(6, results[1]);
    }


}
