package com.coding.scaler.bit_manipulation;

public class APowerBModC {

    /**
     * You are given A, B and C .
     * Calculate the value of (A ^ B) % C
     *
     *Input 1:
     * A = 2
     * B = 3
     * C = 3
     *
     * Output 1:
     * 2
     *
     * For Input 1:
     * (2 ^ 3) % 3 = 8 % 3 = 2
     */
    public static void main(String[] args) {
        System.out.println(solve(2, 3, 3));
    }

    //similar loop logic as SetBit -> MagicNumbers
    private static int solve(int x, int y, int p) {
        int res = 1; // Initialize result

        x = x % p; // Update x if it is more than or equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0) {
            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2

            x = (x * x) % p;
        }
        return res;
    }

    /**
     * Given a number in the form of an array A of size N. Each of the digits
     * of the number is represented by A[i]. Check if the number is divisible by 3.
     */
    private static int solve(int[] A) {
        long sum = 0, x = 1;

        for(int i=A.length-1; i >= 0; i--) {
            sum = (sum + A[i] * x) % 3;
            x = (x * 10) % 3;
        }

        return sum == 0 ? 1 : 0;
    }

    public int solve(String A) {
        long sum = 0, x = 1;
        for(int i=0; i < A.length(); i++) {
            sum = (sum + Character.digit(A.charAt(i), 10) * x) % 8;
        }
        return sum == 0 ? 1 : 0;
    }
}
