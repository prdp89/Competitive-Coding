package com.coding.scaler.advance.dp;

import java.util.Scanner;

public class NthFibonacciNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n==0) {
            System.out.print(0);
            return;
        }


        if(n <= 2) {
            System.out.print(1);
            return;
        }

        int [] dp = new int[n+1];

        dp[1] = 1; dp[2] = 1;
        for(int i=3; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.print(dp[n]);
    }
}
