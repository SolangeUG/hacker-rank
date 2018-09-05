package org.training.java.algorithms.medium;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.binarySearch;
import static java.util.stream.IntStream.of;
import static java.util.stream.IntStream.range;

/**
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *  - The player with the highest score is ranked number  on the leaderboard.
 *  - Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately
 *    following ranking number.
 * For example, the four players on the leaderboard have high scores of 100, 90, 90, and 80.
 * Those players will have ranks 1, 2, 2, and 3, respectively. If Alice's scores are 70, 80 and 105, her rankings
 * after each game are 4th, 3rd and 1st.
 *
 * @author Solange U. Gasengayire
 */
public class ClimbingTheLeaderboard {

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new File("data/leaderboard_input.txt"));
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
            e.printStackTrace();
        }
    }

    /**
     * Check whether input array values are within 0 <= i <= Math.pow(10, 7)
     * @param scores an array of integers that represent leaderboard scores
     * @param alice an array of integers that represent Alice's scores
     * @return true if input values are valid, false otherwise.
     */
    private static boolean validateInput(int[] scores, int[] alice) {
        if (scores.length == 0 || alice.length == 0) {
            return false;
        }

        int minValue = 0;
        int maxValue = (int) Math.pow(10, 9);

        int scoresSize = scores.length;
        if (scores[0] > maxValue || scores[scoresSize - 1] < minValue) {
            return false;
        }

        int[] aliceCopy = Arrays.copyOf(alice, alice.length);
        Arrays.sort(aliceCopy);
        int aliceSize = aliceCopy.length;
        return aliceCopy[0] >= minValue && aliceCopy[aliceSize - 1] <= maxValue;
    }

    /**
     * Return an integer array where each element res[j] represents Alice's rank after the jth game
     * @param scores an array of integers that represent leaderboard scores
     * @param alice an array of integers that represent Alice's scores
     * @return an array of integers that represent Alice's ranks
     */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[]{};

        if (validateInput(scores, alice)) {
            int size = alice.length;
            result = new int[size];

            int[] uniqueScores = of(scores).distinct().toArray();
            int maxNdx = uniqueScores.length - 1;
            for (int j = 0; j < size; j++) {
                int score = alice[j];
                while (maxNdx >= 0) {
                    if (score >= uniqueScores[maxNdx]) {
                        // alice's score is higher than scores encounted so far
                        maxNdx--;
                    } else {
                        // alice's score is lower or equal to current score
                        // so, we mark this position
                        result[j] = maxNdx + 2;
                        break;
                    }
                }
                if (maxNdx < 0) {
                    // alice's score is higher than all the other scores
                    result[j] = 1;
                }
            }

        }

        return result;
    }

    /**
     * Entry point
     * @param args program arguments
     * @throws IOException exception thrown in case of input or output errors
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        String skipRegEx = "(\r\n|[\n\r\u2028\u2029\u0085])?";
        scanner.skip(skipRegEx);

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip(skipRegEx);

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip(skipRegEx);

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip(skipRegEx);

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
