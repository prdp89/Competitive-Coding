package com.coding.scaler.advance.bit_manipulation;

import java.util.Arrays;

public class BinaryPrefixDivBy5 {

    /**
     * https://leetcode.com/problems/binary-prefix-divisible-by-5/description/
     *
     * You are given a binary array nums (0-indexed).
     *
     * We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
     *
     * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
     * Return an array of booleans answer where answer[i] is true if xi is divisible by 5
     *
     * Input: nums = [0,1,1]
     * Output: [true,false,false]
     *
     * Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
     * Only the first number is divisible by 5, so answer[0] is true.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(prefixesDivBy5(new int[] {0, 1, 1})));
    }

    private static boolean [] prefixesDivBy5(int[] nums) {
        int res = 0, i =0;
        boolean [] resArr= new boolean[nums.length];

        for(int item: nums) {
            res = ((res << 1) + item) % 5;
            resArr[i++] = res == 0;
        }

        return  resArr;
    }
}
