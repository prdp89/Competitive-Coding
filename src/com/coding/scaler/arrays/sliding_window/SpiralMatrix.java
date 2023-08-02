package com.coding.scaler.arrays.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {

    /**
     * Given an integer A, generate a square matrix filled with elements from 1 to A2
     * in spiral order and return the generated square matrix.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {6, 5, 4},
                {9, 8, 7}
        };

        //generateSpiralMatrix(mat).forEach(System.out::println);
        generateSpiralFromN(5).forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> generateSpiralFromN(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Integer[][] temp = generateSpiralMatrixDup(A);
        for (Integer[] array : temp) {
            res.add(new ArrayList(Arrays.asList(array)));
        }

        return res;
    }

    private static List<Integer> generateSpiralMatrix(Integer[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0)
            return res;

        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        int dir = 0;

        while (startRow <= endRow && startCol <= endCol) {

            switch (dir) {
                case 0: //Right
                {
                    for (int col = startCol; col <= endCol; col++) {
                        res.add(matrix[startRow][col]);
                    }
                    startRow++;
                    break;
                }

                case 1: //Down
                {
                    for (int row = startRow; row <= endRow; row++) {
                        res.add(matrix[row][endCol]);
                    }
                    endCol--;
                    break;
                }

                case 2: //Left
                {
                    for (int col = endCol; col >= startCol; col--) {
                        res.add(matrix[endRow][col]);
                    }
                    endRow--;
                    break;
                }

                case 3: //Up
                {
                    for (int row = endRow; row >= startRow; row--) {
                        res.add(matrix[row][startCol]);
                    }
                    startCol++;
                    break;
                }
            }
            dir = (dir + 1) % 4;
        }

        return res;
    }

    private static Integer[][] generateSpiralMatrixDup(int A) {
        Integer[][] res = new Integer[A][A];

        int startRow = 0, endRow = res.length - 1;
        int startCol = 0, endCol = res[0].length - 1;
        int dir = 0, count = 1;

        while (startRow <= endRow && startCol <= endCol) {

            switch (dir) {
                case 0: //Right
                {
                    for (int col = startCol; col <= endCol; col++) {
                        res[startRow][col] = count++;
                    }
                    startRow++;
                    break;
                }

                case 1: //Down
                {
                    for (int row = startRow; row <= endRow; row++) {
                        res[row][endCol] = count++;
                    }
                    endCol--;
                    break;
                }

                case 2: //Left
                {
                    for (int col = endCol; col >= startCol; col--) {
                        res[endRow][col] = count++;
                    }
                    endRow--;
                    break;
                }

                case 3: //Up
                {
                    for (int row = endRow; row >= startRow; row--) {
                        res[row][startCol] = count++;
                    }
                    startCol++;
                    break;
                }
            }
            dir = (dir + 1) % 4;
        }

        return res;
    }
}
