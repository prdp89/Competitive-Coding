package com.coding.leetcode.contests.biweekely.biweekely36;

import java.util.Arrays;

public class FindValidMatix {

    //https://leetcode.com/contest/biweekly-contest-36/problems/find-valid-matrix-given-row-and-column-sums/
    public static void main( String[] args ) {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};

        System.out.println(Arrays.deepToString(restoreMatrix(rowSum, colSum)));
    }

    //A greedy solution of Placing a Number and decrement from rowSum/colSum
    private static int[][] restoreMatrix( int[] rowSum, int[] colSum ) {
        int[][] res = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;

        while (i < rowSum.length && j < colSum.length) {
            int min = Math.min(rowSum[i], colSum[j]);

            //placing min of both
            res[i][j] = min;

            //decrement xth value from RowSum/ColSum
            rowSum[i] -= min;
            colSum[j] -= min;

            if (rowSum[i] == 0)
                i++;

            if (colSum[j] == 0)
                j++;
        }

        return res;
    }
}
