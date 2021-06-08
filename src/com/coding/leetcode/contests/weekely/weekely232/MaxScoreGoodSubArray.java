package com.coding.leetcode.contests.weekely.weekely232;

public class MaxScoreGoodSubArray {

    //https://leetcode.com/problems/maximum-score-of-a-good-subarray/
    public static void main( String[] args ) {
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;

        System.out.println(maximumScore(nums, k));
    }

    //uSING LOGIC OF LargestRectInHistogram or MaximumHistogram in stackorQueue excel
    //K should be somewhere bw i..k...j that means nums[k] is default minimum.
    private static int maximumScore( int[] nums, int k ) {
        int n = nums.length, minScore = nums[k], lo = 0, hi = nums.length - 1;

        int[] runningArrIndexK = new int[n];
        runningArrIndexK[k] = minScore;

        for (int i = k + 1; i < n; i++) {
            runningArrIndexK[i] = Math.min(runningArrIndexK[i - 1], nums[i]);
        }

        for (int i = k - 1; i >= 0; i--) {
            runningArrIndexK[i] = Math.min(runningArrIndexK[i + 1], nums[i]);
        }

        while (lo <= hi) {
            minScore = Math.max(minScore,
                    (hi - lo + 1) * Math.min(runningArrIndexK[lo], runningArrIndexK[hi]));

            if (hi == k || runningArrIndexK[lo] < runningArrIndexK[hi])
                lo++;
            else
                hi--;
        }

        return minScore;
    }
}
