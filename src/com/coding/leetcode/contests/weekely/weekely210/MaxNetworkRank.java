package com.coding.leetcode.contests.weekely.weekely210;

public class MaxNetworkRank {

    //https://leetcode.com/contest/weekly-contest-210/problems/maximal-network-rank/
    public static void main( String[] args ) {
        int[][] roads = {
                {0, 1},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        int n = 4;

        System.out.println(maximalNetworkRank(n, roads));
    }

    private static int maximalNetworkRank( int n, int[][] roads ) {
        boolean[][] connect = new boolean[n][n];

        int[] counts = new int[n];
        for (int[] road : roads) {
            counts[road[0]]++;
            counts[road[1]]++;

            //storing road[0] and road[1] to check later if directly connected
            connect[road[0]][road[1]] = true;
            connect[road[1]][road[0]] = true;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                int doubleConnected = connect[i][j] ? 1 : 0;
                res = Math.max(res, counts[i] + counts[j] - doubleConnected);
            }
        }

        return res;
    }
}
