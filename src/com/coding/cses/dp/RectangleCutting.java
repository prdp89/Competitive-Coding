//package com.coding.cses.dp;

import java.util.Scanner;

public class RectangleCutting {

    //https://leetcode.com/discuss/general-discussion/868902/dynamic-programming
    //https://cses.fi/problemset/task/1744

    //https://www.youtube.com/watch?v=LdynQjWsO5Q&list=PLb3g_Z8nEv1h1w6MI8vNMuL_wrI0FtqE7&index=15

    //Recurrence:
    //doing vertical cut : dp[a,b] = { 1 + dp (a, b - i) + dp (a, i) }
    //doing horizontal cut : dp[a,b] = { 1 + dp (a-i, b) + dp (i, b) }
    //Final ans = min ( vertical , horizontal)
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[][] dp = new int[a + 1][b + 1];

        for (int height = 1; height <= a; height++) {

            for (int width = 1; width <= b; width++) {

                //base cae:
                //if it's already a square no need to make a cut
                if (height == width) {
                    dp[height][width] = 0;
                } else {
                    int ans = (int) 1e8;
                    //if we are doing vertical cut in A x B rectangle then we are left with:
                    //1. {a, b-i}  2. { a, i} rectangles..
                    for (int i = 1; i < width; i++)
                        ans = Math.min(ans, 1 + dp[height][width - i] + dp[height][i]);

                    //same will happen for horizontal cut
                    for (int i = 1; i < height; i++)
                        ans = Math.min(ans, 1 + dp[height - i][width] + dp[i][width]);

                    dp[height][width] = ans;
                }
            }
        }

        System.out.println(dp[a][b]);
    }
}
