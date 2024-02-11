package com.coding.scaler.advance.arrays.sorting.radix_quick;

import java.util.Arrays;

public class SumTheDifference {

    /**
     * Given an integer array, A of size N.
     * You have to find all possible non-empty subsequences of the array of numbers and then,
     * for each subsequence, find the difference between the largest and smallest number in that subsequence.
     * Then add up all the differences to get the number.
     *
     * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
     *
     * NOTE: Subsequence can be non-contiguous.
     *
     * Input 1:
     *
     * A = [1, 2]
     *
     * Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     * All possible non-empty subsets are:
     * [1]     largest-smallest = 1 - 1 = 0
     * [2]     largest-smallest = 2 - 2 = 0
     * [1, 2]  largest-smallest = 2 - 1 = 1
     * Sum of the differences = 0 + 0 + 1 = 1
     * So, the resultant number is 1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2}));
    }

    private static int solve(int[] A) {
        int n = A.length;
        double max = 0, min = 0;
        double diff;
        double mod = 1000000007;

        Arrays.sort(A);

        // max and min of sub sequence
        for(int i = 0; i < n; i++) {
            double maxcontribution = (A[i] * Math.pow(2,i)) % mod;
            max = (max + maxcontribution) % mod;
            double mincontribution = (A[i] *  Math.pow(2,(n - 1 -i))) % mod;
            min = (min + mincontribution) % mod;
        }

        diff = (max -min + mod) % mod;
        return (int)diff;
    }
}
