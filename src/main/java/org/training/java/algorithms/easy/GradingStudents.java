package org.training.java.algorithms.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * HackerLand University has the following grading policy:
 * - Every student receives a grade in the inclusive range from 0 to 100.
 * - Any grade less than 40 is a failing grade.
 *
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 * - If the difference between the grade and the next multiple of 5 is less than 3, round  up to the next multiple of 5.
 * - If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 *
 * For example,grade = 84 will be rounded to 85 but 29 will not be rounded because the rounding would result in a number
 * that is less than 40.
 *
 * Given the initial value of grade for each of Sam's n students, write code to automate the rounding process.
 *
 * @author Solange U. Gasengayire
 */
public class GradingStudents {

    private static final Scanner scan = new Scanner(System.in);

    /**
     * Check whether input array values are within 0 <= i <= 100
     * @param grades an integer array of students grades
     * @return true if input values are valid, false otherwise.
     */
    private static boolean validateInput(int[] grades) {
        int size = grades.length;
        if (size == 0) {
            return false;
        }

        int[] copy = Arrays.copyOf(grades, size);
        Arrays.sort(copy);
        return copy[0] >= 0 && copy[size -1] <= 100;
    }

    /**
     * Return an integer array of rounded grades
     * @param grades an integer array of students grades before rounding
     * @return rounded grades
     */
    static int[] gradingStudents(int[] grades) {
        int[] result = {};

        if (validateInput(grades)) {
            int size = grades.length;
            result = new int[size];

            int roundingLimit = 38;
            for (int i = 0; i < size; i++) {
                if (grades[i] < roundingLimit) {
                    // grades lower than 38 are not rounded
                    result[i] = grades[i];
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
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }

}
