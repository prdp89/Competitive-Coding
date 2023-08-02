package com.coding.scaler.bit_manipulation;

public class AnyBaseToDecimal {

    /**
     * You are given a number A. You are also given a base B. A is a number on base B.
     * You are required to convert the number A into its corresponding value in decimal number system.
     *
     * Input 1:
     * A = 1010
     * B = 2
     *
     * Output 1:
     * 10
     */

    public static void main(String[] args) {
        System.out.println( solve(1010, 2));
    }

    private static int solve(int A, int B) {
        int sum =0, i = 0;
        while(A > 0) {
            //to convert to decimal base
            int lastDigit = A % 10;

            //previous number is of base B, so B^i
            sum += lastDigit * (int)Math.pow(B, i);

            i++;
            A = A / 10;
        }

        return sum;
    }
}
