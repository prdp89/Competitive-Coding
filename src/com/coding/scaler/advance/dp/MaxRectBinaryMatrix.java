package com.coding.scaler.advance.dp;

public class MaxRectBinaryMatrix {

    /**
     * Given a 2-D binary matrix A of size N x M filled with 0's and 1's,
     * find the largest rectangle containing only ones and return its area.
     *
     * A = [
     *        [1, 1, 1]
     *        [0, 1, 1]
     *        [1, 0, 0]
     *      ]
     *
     * Output 1:
     *  4
     */
    public static void main(String[] args) {
        int [][] matrix = {
                {1, 1, 1},
                {0,1,1},
                {1,0,0}
        };
        System.out.println(maximalRectangle(matrix));
    }

    private static int maximalRectangle(int[][] matrix) {
        if (matrix.length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int n = matrix.length, m = matrix[0].length;

        //transferring all the element to another matrice dp matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) dp[i][j] = matrix[i][j];
        }

        //if we are thinking in "MaximumHistogram", DP[] array calculates height of each bar in histogram
        for (int i = 0; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (dp[i][j] > 0)
                    dp[i][j] += dp[i][j-1];
            }
        }

        int ans = 0;


        //now from that prefix col sum we will calculate the max row sum giong at each and
        //every element and including more and more rows at particular height
        for (int i = 0; i < n; i++) { //tc: n*m*n

            // 'MaximumHistogram' solution : easy one :p
            for (int j = 0; j < m; j++) {
                int area = 0, height = 1, min = Integer.MAX_VALUE;

                for (int row = i; row >= 0; row--) { //going up the height taking more and more element up
                    min = Math.min(min, dp[row][j]);
                    area = Math.max(area, min * height);
                    height++;
                }
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}
