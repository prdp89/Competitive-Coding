package com.coding.scaler.advance.maths.gcd;

public class ADivideBAndC {

    /**
     * Scooby has 3 three integers A, B, and C.
     *
     * Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
     * You need to tell the number of special integers less than or equal to A.
     *
     * Input 1:
     *
     *  A = 12
     *  B = 3
     *  C = 2
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(12,3,2));
    }

    //LCM or Least Common Divisor (4, 5) = 20. Here, the LCM 20 is divisible by both 4 and 5 such that 4 and 5 are called the divisors of 20.
    private static int solve(int A, int B, int C) {
        int lcm = B * C / gcd(B,C);

        return A/lcm;
    }

    private static int gcd(int a, int b) {
        if(b <= 0)
            return a;

        return gcd(b , a%b);
    }
}
