//package com.coding.cses.dp;

import java.util.Scanner;

public class TwoSetsII {

    //https://cses.fi/problemset/task/1093/

    //passing 19/ 26 test cases

    //similar to SubsetSumCount
    public static void main( String[] args ) {
        int mod = (int) 1e9 + 7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (((n * (n + 1)) % 4) != 0) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n + 1][n * n];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // process all subsets for all sums
        for (int i = 1; i <= n; i++) {

            for (int s = 0; s <= ((n * (n + 1)) / 4); s++) {

                // exclude the number
                dp[i][s] = dp[i - 1][s] % mod;

                // include the number, if it does not exceed the sum
                if (s >= i)
                    dp[i][s] += dp[i - 1][s - i] % mod;
            }
        }

        //This is: 500000004: module inverse of 2 of 10e9+7
        System.out.println(((dp[n][(n * (n + 1)) / 4]) * 500000004) % mod);

        //System.out.println(((dp[n][(n * (n + 1)) / 4]) % mod) / 2);
    }
}
