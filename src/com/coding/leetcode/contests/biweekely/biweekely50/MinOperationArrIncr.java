package com.coding.leetcode.contests.biweekely.biweekely50;

public class MinOperationArrIncr {

    //https://leetcode.com/contest/biweekly-contest-50/problems/minimum-operations-to-make-the-array-increasing/
    public static void main( String[] args ) {
        int[] nums = {1, 5, 2, 4, 1};
        System.out.println(minOperations(nums));
    }

    private static int minOperations( int[] nums ) {

        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
