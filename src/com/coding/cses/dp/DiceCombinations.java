//package com.coding.cses.dp;

import java.util.Scanner;

public class DiceCombinations {

    //https://cses.fi/problemset/task/1633
    //https://www.youtube.com/watch?v=5gd5jptXWAM&list=PLb3g_Z8nEv1h1w6MI8vNMuL_wrI0FtqE7&index=4

    //It is same as : CoinChangeTotalWays : com.interview.codingblocks.week9DynamicProgrammming
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int mod = (int) 1e9 + 7;
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 0; i <= n; i++) {

            for (int dice = 1; dice <= 6; dice++) {
                if (i >= dice) {
                    dp[i] = (dp[i] + dp[i - dice]) % mod;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
