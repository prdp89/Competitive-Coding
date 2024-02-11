package com.coding.scaler.advance.dp;

import java.util.Arrays;

public class DungeonGame {

    //https://leetcode.com/problems/dungeon-game/description/
    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        }));
    }

    private static int calculateMinimumHP(int[][] A) {
        int n = A.length, m = A[0].length;

        int [][] dp = new int[n+1][m+1];

        for (int[] row: dp)
            Arrays.fill(row, (int)1e9);

        dp[n][m-1] = 1;
        dp[n-1][m] = 1;

        //now start from second last row of DP to calculate last row of dungeon values
        for (int i= n-1; i>=0; i--) {

            for (int j=m-1; j>=0; j--) {
                // Math.min(dp[i+1][j], dp[i][j+1]) : min power from bottom and right to survive
                // - A[i][j] => fighting the cell with min power.
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - A[i][j];

                dp[i][j] = need <= 0? 1 : need;
            }
        }
        return dp[0][0];
    }
}
