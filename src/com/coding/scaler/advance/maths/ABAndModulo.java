package com.coding.scaler.advance.maths;

public class ABAndModulo {

    /**
     * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
     *
     * Input 2:
     *
     * A = 5
     * B = 10
     *
     * Output 2:
     *
     * 5
     *
     * For M = 5, A % M = 0 and B % M = 0.
     *
     * No value greater than M = 5, satisfies the condition.
     */
    public static void main(String[] args) {
        System.out.println( solve(5, 10));
    }

    private static int solve(int A, int B) {
        int gcd = 0;
        if(A > B) {
            gcd = A - B;
        } else if(B > A) {
            gcd = B - A;
        }

        if(A % gcd == B % gcd)
            return gcd;

        return gcd;
    }
}
