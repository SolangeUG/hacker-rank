package org.training.java.algorithms.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * You are given a 2D matrix of dimension m x n  and a positive integer r. You have to rotate the matrix r times
 * and print the resultant matrix. Rotation should be in anti-clockwise direction.
 *
 * @author Solange U. Gasengayire
 */
public class MatrixLayerRotation {

    /**
     * Rotate the input matrix r times, and print the resultant 2D integer array.
     * @param matrix a 2D integer array.
     * @param r an integer that represents the rotation factor.
     */
    private static void matrixRotation(List<List<Integer>> matrix, int r) {
        // TODO: implement method logic!
    }

    /**
     * Entry point
     * @param args program arguments
     * @throws IOException exception thrown in case of input or output errors
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String skipRegEx = "\\s+$";
        String[] inputParams = bufferedReader.readLine().replaceAll(skipRegEx, "").split(" ");

        int m = Integer.parseInt(inputParams[0]);
        int n = Integer.parseInt(inputParams[1]);
        int r = Integer.parseInt(inputParams[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll(skipRegEx, "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }

}
