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
        int[] scores = {80, 120, -5, 0};
        int[] aliceScores = {100, 40};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{80, 120, 70, 50};
        aliceScores = new int[]{0, 15, -10};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("make sure input parameters are within bounds")
    void makeSureInputParametersAreWithinBounds() {
        int[] scores = {80, 120, 20, Integer.MAX_VALUE};
        int[] aliceScores = {100, 40};
        int[] result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);

        scores = new int[]{80, 120, 70, Integer.MIN_VALUE};
        aliceScores = new int[]{0, 15, Integer.MAX_VALUE};
        result = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
        assertEquals(0, result.length);
    }

}
