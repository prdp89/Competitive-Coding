package com.coding.scaler.bit_manipulation;

public class SetBit {

    /**
     * You are given two integers A and B.
     * Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
     * <p>
     * Input 1:
     * A = 3
     * B = 5
     * <p>
     * Output 1:
     * 40
     * <p>
     * For Input 1:
     * The binary expression is 101000 which is 40 in decimal.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(3, 5));

        System.out.println(solveMagicNums(4));
    }

    private static int solve(int A, int B) {
        int num1 = (0 | (1 << A));
        int num2 = (num1 | (1 << B));

        return num2;
    }

    /**
     * Given an integer A, find and return the Ath magic number.
     *
     * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
     *
     * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
     *
     * Example Input 1:
     *
     *  A = 3
     *
     *  Example Output 1:
     *
     *  30
     *
     *  Explanation 1:
     *
     *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
     *  3rd element in this is 30
     */
    private static int solveMagicNums(int A) {
        int ans = 0, x = 1;
        while (A > 0) {
            x *= 5;
            if ((A & 1) == 1) {
                ans += x;
            }
            A = A >> 1;
        }
        return ans;
    }
}
