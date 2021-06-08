package com.coding.leetcode.contests.weekely.weekely231;

public class MinElemGivenSumAndLimit {

    //https://leetcode.com/contest/weekly-contest-231/problems/minimum-elements-to-add-to-form-a-given-sum/
    public static void main( String[] args ) {
        int[] nums = {1, -1, 1};
        int limit = 3, goal = -4;

        System.out.println(minElements(nums, limit, goal));
    }

    //a greedy approach
    private static int minElements( int[] nums, int limit, int goal ) {
        long sum = 0;
        for (int item : nums)
            sum += item;

        //first find diff to the goal
        long diff = Math.abs(goal - sum);

        //now num of elements to make goal and considering within limit is
        long ans = diff / limit;
        if (diff % limit != 0)
            ans++;

        return (int) ans;
    }
}
