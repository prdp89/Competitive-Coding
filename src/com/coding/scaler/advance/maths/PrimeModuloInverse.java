package com.coding.scaler.advance.maths;

public class PrimeModuloInverse {

    public static void main(String[] args) {
        System.out.println(solve(3, 5));
    }

    /**
     * Given two integers A and B. Find the value of A inverse mod B where B is a prime number and gcd(A, B) = 1.
     *
     * A^-1 mod B is also known as modular multiplicative inverse of A under modulo B.
     *
     * Input 1:
     *
     *  A = 3
     *  B = 5
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  Let's say A inverse mod B = X, then (A * X) % B = 1.
     *  3 * 2 = 6, 6 % 5 = 1.
     *
     *  Using Fermat little theorem:
     *
     *  A^-1 mod m  = A ^ m-2 mod m
     */
    private static int solve(int A, int B) {
        return pow(A, B-2, B);
    }

    private static int pow(int a, int b, int c) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;

        long ha = pow(a, b/2, c);
        long hp = ((ha % c) * (ha % c)) % c;

        if(b % 2 == 1) {
            int x = (int) (((hp % c) * (a % c)) % c);
            if(x < 0){
                x+=c;
            }
            return x;
        } else {
            return (int) hp;
        }
    }
}
