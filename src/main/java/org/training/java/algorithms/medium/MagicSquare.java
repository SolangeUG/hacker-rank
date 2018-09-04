package org.training.java.algorithms.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * We define a magic square to be an n x n matrix of distinct positive integers from 1 to n² where the sum of any row,
 * column, or diagonal of length n is always equal to the same number: the magic constant.
 *
 * You will be given a 3 x 3 matrix s of integers in the inclusive range [1, 9].
 * We can convert any digit a to any other digit b in the range [1, 9] at cost of |a-b|.
 * Given s, convert it into a magic square at minimal cost. Print this cost on a new line.
 *
 * Note: The resulting magic square must contain distinct integers in the inclusive range [1, 9].
 *
 * @author Solange U. Gasengayire
 */
public class MagicSquare {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Check whether input matrix values are within 1 <= i <= 9 range
     * @param matrix input matrix
     * @return true if input values are valid, false otherwise
     */
    private static boolean validateInput(int[][] matrix) {
        int size = matrix.length;
        if (size < 1) {
            return false;
        }

        for (int[] row : matrix) {
            for (int element: row) {
                if (element < 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Convert a given matrix into a magix square at minimal cost
     * @param s input matrix to convert
     * @return the conversion cost
     */
    static int formingMagicSquare(int[][] s) {
        int result = -1;

        if (validateInput(s)) {
            // TODO: implement magic square logic
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

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
