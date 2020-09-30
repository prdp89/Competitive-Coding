package com.coding.cses.dp;

import java.util.Scanner;

public class RemovingDigits {

    //https://cses.fi/problemset/task/1637
    //https://cses.fi/problemset/result/1061636/

    //https://www.youtube.com/watch?v=32qvB7OP4V8&list=PLb3g_Z8nEv1h1w6MI8vNMuL_wrI0FtqE7&index=7
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];

        //if num is zero the no step is required
        dp[0] = 0;

        //Similar to CoinChangeMinCoins
        for (int i = 1; i <= n; i++) {
            //we start by finding MIn. num of steps for i then slowly reach to N

            int temp = i;
            int minSteps = (int) 1e6 + 2;

            while (temp != 0) {
                int lastDigit = temp % 10;
                temp /= 10;

                //we don't want to consider zero digit; as this lead to wrong answer..
                if (lastDigit == 0)
                    continue;

                minSteps = Math.min(minSteps, 1 + dp[i - lastDigit]);
            }

            dp[i] = minSteps;
        }

        System.out.println(dp[n]);
    }
}
