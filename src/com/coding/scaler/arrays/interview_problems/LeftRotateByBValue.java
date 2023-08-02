package com.coding.scaler.arrays.interview_problems;

import java.util.Arrays;

public class LeftRotateByBValue {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(new int[] {1, 2, 3, 4, 5}, new int[] {2,3})));
    }

    /**
     * Given an array of integers A and multiple values in B, which represents the
     * number of times array A needs to be left rotated.
     * <p>
     * Find the rotated array for each value and return the result in the from
     * of a matrix where ith row represents the rotated array for the ith value in B.
     * <p>
     * Input 1:
     * <p>
     * A = [1, 2, 3, 4, 5]
     * B = [2, 3]
     * <p>
     * Output 1:
     * <p>
     * [ [3, 4, 5, 1, 2]  //rotate 2 times B[0]
     * [4, 5, 1, 2, 3] ] //rotate 3 times B[1]
     *
     * @param A
     * @param B
     * @return
     */
    private static int[][] solve(int[] A, int[] B) {
        int n = B.length;
        int m = A.length;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                //current element will be pushed B[i] times to the left
                arr[i][j] = A[(j + B[i]) % m];
            }
        }

        return arr;
    }
}
