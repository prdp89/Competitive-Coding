package com.coding.leetcode.contests.weekely.weekely233;

public class MaxAscendingSum {

    //https://leetcode.com/contest/weekly-contest-233/problems/maximum-ascending-subarray-sum/
    public static void main( String[] args ) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }

    //Runtime: 0 ms
    //Memory Usage: 36.3 MB
    private static int maxAscendingSum( int[] nums ) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += cur;
            } else {
                sum += cur;
                max = Math.max(max, sum);
                sum = 0;
            }
            cur = nums[i];
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            sum += nums[nums.length - 1];
            max = Math.max(sum, max);
        }

        return Math.max(cur, max);
    }
}
