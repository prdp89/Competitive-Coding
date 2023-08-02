package com.coding.scaler.recursion;

public class PrintOneToN {

    public static void main(String[] args) {
        solve(10);
    }

    private static void solve(int A) {
        if(A==0)
            return;

        solve(A-1);
        System.out.println(A);
    }
}
