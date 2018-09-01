package org.training.java.algorithms.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each
 * year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones.
 * Your task is to find out how many candles she can successfully blow out.
 *
 * @author Solange U. Gasengayire
 */
public class BirthdayCakeCandles {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Check whether input array values are within 0 <= i <= Mapth(10, 7)
     * @param parameters an array of integers
     * @return true if input values are valid, false otherwise.
     */
    private static boolean isValid(int[] parameters) {

        // input array shouldn't be empty
        int size = parameters.length;
        if (size == 0) {
            return false;
        }

        // are all array values within bounds?
        int minimum = 0;
        int maximum = (int) Math.pow(10, 7);
        Arrays.sort(Arrays.stream(parameters).boxed().toArray(Integer[]::new),
                    Comparator.reverseOrder());

        return parameters[0] <= maximum
                && parameters[size - 1] >= minimum;
    }

    /**
     * Return an integer representing the number of candles that can be blown out.
     * @param heights an integer array representing candle heights
     * @return total number of candles that can be blown out.
     */
    public static int birthdayCakeCandles(int[] heights) {
        int result = -1;

        if (isValid(heights)) {
            //TODO : complete
        }

        return result;
    }

    /**
     * Entry point
     * @param args program arguments
     * @throws IOException exception thrown in case of input or output errors
     */
    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        int itemCount = scanner.nextInt();
        String skipRegEx = "(\r\n|[\n\r\u2028\u2029\u0085])?";
        scanner.skip(skipRegEx);

        int[] items = new int[itemCount];

        String[] inputItems = scanner.nextLine().split(" ");
        scanner.skip(skipRegEx);

        for (int i = 0; i < itemCount; i++) {
            int item = Integer.parseInt(inputItems[i]);
            items[i] = item;
        }

        int result = birthdayCakeCandles(items);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
