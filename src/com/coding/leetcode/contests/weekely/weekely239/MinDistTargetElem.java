package com.coding.leetcode.contests.weekely.weekely239;

import java.util.HashSet;

public class MinDistTargetElem {

    //https://leetcode.com/contest/weekly-contest-239/problems/minimum-distance-to-the-target-element/
    public static void main( String[] args ) {
        int[] nums = {1};
        int t = 1, s = 0;
        System.out.println(getMinDistance(nums, t, s));
    }

    //72 / 72 test cases passed.
    //Status: Accepted
    //Runtime: 1 ms
    private static int getMinDistance( int[] nums, int target, int start ) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                set.add(i);
        }

        int res = Integer.MAX_VALUE;
        for (int item : set) {
            res = Math.min(res, Math.abs(item - start));
        }

        return res;
    }

    //one pass
    public int getMinDistance_1_pass( int[] nums, int target, int start ) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(start - i));
            }
        }

        return res;
    }
}
