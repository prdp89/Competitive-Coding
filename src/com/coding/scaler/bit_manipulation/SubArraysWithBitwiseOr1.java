package com.coding.scaler.bit_manipulation;

public class SubArraysWithBitwiseOr1 {

    /**
     * Given an array B of length A with elements 1 or 0. Find the number of subarrays such that
     * the bitwise OR of all the elements present in the subarray is 1.
     * Note : The answer can be large. So, return type must be long.
     *
     * Input 1:
     *  A = 3
     *  B = [1, 0, 1]
     *
     *  Output 1:
     *  5
     *
     *  Explanation 1:
     * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
     * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
     */
    public static void main(String[] args) {
        int [] arr = {1, 0, 1};
        int A = 3;

        System.out.println(solve(A, arr));
    }

    /**
     * Similar to contribution technique below tech count Sub-Arrays sum till ith position.
     */
    private static long solve(int A, int[] B) {
        long total = 0;
        int count = 0;
        for(int i=0; i < A; i++) {
            if(B[i] == 1) {
                count = i + 1;
            }
            total = total + count;
        }
        return total;
    }
}
