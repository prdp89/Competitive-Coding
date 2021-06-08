package com.coding.leetcode.contests.biweekely.biweekely45;

import java.util.HashMap;
import java.util.Map;

public class MaxAbsSumSubArray {

    //https://leetcode.com/contest/biweekly-contest-45/problems/maximum-absolute-sum-of-any-subarray/
    public static void main( String[] args ) {
        int[] nums = {1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(nums));
    }

    private static int maxAbsoluteSum( int[] nums ) {
        Map<Integer, Integer> leftSum = new HashMap<>();
        leftSum.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            leftSum.put(i + 1, nums[i] + leftSum.get(i));
        }

        Map<Integer, Integer> rightSum = new HashMap<>();
        rightSum.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            rightSum.put(i + 1, nums[nums.length - 1 - i] + rightSum.get(i));
        }

        int sum = 0;
        for (int i : leftSum.keySet()) {

            int left = leftSum.get(i);
            int right = rightSum.getOrDefault(nums.length - i, 0);

            sum = Math.max(sum, Math.max((Math.abs(left) + right), Math.abs(right) + left));
        }

        return sum;
    }

    //https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/discuss/1052504/JavaPython-3-Prefix-Sum-Time-O(n)-space-O(1).
    public int maxAbsoluteSum_prefix( int[] nums ) {
        int mi = 0, mx = 0;
        for (int i = 0, prefixSum = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            mi = Math.min(mi, prefixSum);
            mx = Math.max(mx, prefixSum);
        }
        return mx - mi;
    }

    //https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/discuss/1052471/C%2B%2BJava%3A-Find-Max-and-Min-Sum
    public int maxAbsoluteSum_maxSubArray_logic( int[] nums ) {
        int res = 0, max_sum = 0, min_sum = 0;
        for (int n : nums) {
            max_sum = Math.max(0, n + max_sum);
            min_sum = Math.min(0, n + min_sum);
            res = Math.max(res, Math.max(max_sum, -min_sum));
        }
        return res;
    }
}
