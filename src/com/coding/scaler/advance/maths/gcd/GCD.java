package com.coding.scaler.advance.maths.gcd;

public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(4,6));
    }

    /**
     * Given 2 non-negative integers A and B, find gcd(A, B)
     *
     * GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
     *
     * Note: DO NOT USE LIBRARY FUNCTIONS.
     *
     * TC : O (Log(max(a, b))
     */
    private static int gcd(int a, int b) {
        return fungcd(a, b);
    }

    private static int fungcd(int a, int b) {
        if(b <= 0)
            return a;

        return fungcd(b , a%b);
    }
}
