package com.coding.cses.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoneySums {

    //https://codeforces.com/blog/entry/70018
    //https://cses.fi/problemset/task/1745

    //This is classic example of 0/1 knapsack  ZeroOneKnapsack : https://cses.fi/problemset/result/1062278/
    public static void main( String[] args ) {
        //working: accepted
        two_D_DP();

        //tried: not working
        one_D_DP();
    }

    private static void one_D_DP() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxSum = n * 1000;
        boolean[] dp = new boolean[maxSum + 1];

        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int c = maxSum; c >= 0; c--) {
                if (c >= arr[i] && dp[c - arr[i]])
                    dp[c] = true;

            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxSum; i++)
            if (dp[i])
                list.add(i);

        System.out.println(list.size());

        for (int item : list)
            System.out.print(item + " ");
    }


    private static void two_D_DP() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        //dp[i][x] = true if it is possible to make x using the first i coins, false otherwise.
        int maxSum = n * 1000;
        boolean[][] dp = new boolean[n + 1][maxSum + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= maxSum; j++) {
                dp[i][j] = dp[i - 1][j];

                int prev = j - arr[i - 1];
                if (prev >= 0 && dp[i - 1][prev])
                    dp[i][j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxSum; i++)
            if (dp[n][i])
                list.add(i);

        System.out.println(list.size());

        for (int item : list)
            System.out.print(item + " ");
    }
}
