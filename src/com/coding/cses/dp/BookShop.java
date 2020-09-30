//package com.coding.cses.dp;

import java.util.Scanner;

public class BookShop {

    //same as :ZeroOneKnapsack
    //https://cses.fi/problemset/task/1158

    //https://cses.fi/problemset/result/1061925/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] s = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }

        int[] dp = new int[x + 1];

        for (int i = 0; i < n; i++) {

            for (int c = x; c >= 0; c--) {

                int profit1 = 0, profit2 = 0;

                // include the item, if it is not more than the capacity
                if (s[i] <= c)
                    profit1 = t[i] + dp[c - s[i]];

                // exclude the item
                profit2 = dp[c];

                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }

        System.out.println(dp[x]);
    }
}
