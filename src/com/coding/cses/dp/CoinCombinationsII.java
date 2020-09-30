//package com.coding.cses.dp;

import java.util.Scanner;

public class CoinCombinationsII {

    //same as:CoinChangeWays :com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype
    //https://cses.fi/problemset/task/1636

    //https://cses.fi/problemset/result/1061360/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = scanner.nextInt();

        int mod = (int) 1e9 + 7;

        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][total + 1];

        //for (int i = 0; i < n; i++)
        //  dp[i][0] = 1; //in case of number of ways problems, this is mandatory..

        // process all sub-arrays for all capacities
        for (int i = 1; i <= n; i++) { //index i starts form 0 incase of unbounded knapsack..

            for (int t = 0; t <= total; t++) {

                if (t == 0)
                    dp[i][t] = 1;
                else {
                    //if (i > 0)
                    dp[i][t] = dp[i - 1][t];

                    if (t >= coins[i])
                        dp[i][t] = (dp[i][t] + dp[i][t - coins[i]]) % mod;
                }
            }
        }

        // total combinations will be at the bottom-right corner.
        System.out.println(dp[n][total]);
    }
}
