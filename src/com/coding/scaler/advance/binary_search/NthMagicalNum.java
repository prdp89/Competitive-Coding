package com.coding.scaler.advance.binary_search;

public class NthMagicalNum {

    //https://leetcode.com/problems/nth-magical-number/description/
    public static void main(String[] args) {
        System.out.println( solve(4, 2, 3));
    }

    /**
     * Input 2:
     *
     *  N = 4
     *  A = 2
     *  B = 3
     *
     *  Output 2:
     *
     *  6
     *
     *  Explanation 2:
     *
     *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
     *
     * 4 points to figure out:
     *
     * Get gcd (greatest common divisor) and lcm (least common multiple) of (A, B).
     * (a, b) = (A, B) while b > 0: (a, b) = (b, a % b)
     * then, gcd = a and lcm = A * B / a
     *
     * How many magic numbers <= x ?
     * By inclusion exclusion principle, we have:
     * x / A + x / B - x / lcm
     *
     * Set our binary search range
     * Lower bound is min(A, B), I just set left = 2.
     * Upper bound is N * min(A, B), I just set right = 10 ^ 14.
     *
     * binary search, find the smallest (least) x that x / A + x / B - x / lcm = N
     */
    private static int solve(int n, int a, int b) {
        long lcm = (a*b) / fungcd(a,b), l = 2, r = (long)1e14, mod = (long)1e9+7, ans = 0;

        while(l <= r) {
            long m = (l + r) / 2;
            if (m / a + m / b - m / lcm < n) {
                l = m + 1;
            }
            else r = m-1;
        }

        return (int) (l%mod);
    }

    private static int fungcd(int a, int b) {
        if(b <= 0)
            return a;

        return fungcd(b , a%b);
    }
}
