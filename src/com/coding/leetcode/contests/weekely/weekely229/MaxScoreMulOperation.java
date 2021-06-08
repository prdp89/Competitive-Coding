package com.coding.leetcode.contests.weekely.weekely229;

public class MaxScoreMulOperation {

    //https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
    public static void main( String[] args ) {
        MaxScoreMulOperation max = new MaxScoreMulOperation();
        int[] num = {1, 2, 3};
        int[] mul = {3, 2, 1};

        System.out.println(max.maximumScore(num, mul));
    }

    public int maximumScore( int[] nums, int[] multipliers ) {
        int M = multipliers.length;
        return helper(nums, multipliers, 0, 0, new Integer[M][M]);
    }

    //Runtime: 155 ms, faster than 16.67% of Java
    //https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/discuss/1075469/JavaC%2B%2BPython-3-Top-Down-DP-O(m2)-Clean-and-Concise
    private int helper( int[] nums, int[] multipliers, int left, int i, Integer[][] dp ) {

        if (i == multipliers.length) // Picked enough m elements
            return 0;

        if (dp[left][i] != null)
            return dp[left][i];

        int res = Math.max(nums[left] * multipliers[i] + helper(nums, multipliers, left + 1, i + 1, dp),

                nums[nums.length - (i - left) - 1] * multipliers[i] + helper(nums, multipliers, left, i + 1, dp));

        return dp[left][i] = res;
    }
}