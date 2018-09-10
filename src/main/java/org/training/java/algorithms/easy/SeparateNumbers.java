package org.training.java.algorithms.easy;

import java.util.Scanner;

/**
 * A numeric string s, is beautiful if it can be split into a sequence of two or more positive integers, a[1], ... a[n],
 * satisfying the following conditions:
 *  + a[i] - a[i - 1] = 1 for any 1 < i <= n (i.e., each element in the sequence is 1 more than the previous element).
 *  + No a[i] contains a leading zero. For example, we can split 102030 into the sequence {1, 02, 03}, but it is
 *    not beautiful because 02 and 03 have leading zeroes.
 *  + The contents of the sequence cannot be rearranged. For example, we can split s = 312 into the sequence {3, 1, 2},
 *    but it is not beautiful because it breaks our first constraint (i.e., 1- 3 != 1).
 *
 * @author Solange U. Gasengayire
 */
public class SeparateNumbers {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Return whether or not string s is beautiful.
     * @param s input numeric string
     * @exception NumberFormatException in case input string s is null, empty or can't be converted to an integer.
     * @return "YES x", where x is the first number of the increasing sequence, if s is beautiful.
     *         "NO", otherwise.
     */
    static String separateNumbers(String s) throws NumberFormatException {
        String result = "No";
        Integer value = Integer.valueOf(s);

        int size = s.length();

        // TODO: implement logic!
        int ndx = size/2;
        while (ndx > 0) {
            int current = Integer.valueOf(s.substring(0, ndx));
            size = String.valueOf(current).length();
            int next = Integer.valueOf(s.substring(ndx, ndx + size));

            if (next != current + 1) {
                ndx = ndx / 2;
            } else {
                result = "YES " + current;
                break;
            }
        }

        return result;
    }

    /**
     * Entry point
     * @param args program arguments
     */
    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            System.out.println(separateNumbers(s));
        }

        scanner.close();
    }
}
