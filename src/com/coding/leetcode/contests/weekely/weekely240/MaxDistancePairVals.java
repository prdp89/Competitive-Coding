package com.coding.leetcode.contests.weekely.weekely240;

public class MaxDistancePairVals {

    //https://leetcode.com/contest/weekly-contest-240/problems/maximum-distance-between-a-pair-of-values/
    public static void main( String[] args ) {
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};

        System.out.println(maxDistance(nums1, nums2));
    }

    //32 / 32 test cases passed.
    //Status: Accepted
    //Runtime: 2 ms
    private static int maxDistance( int[] nums1, int[] nums2 ) {
        int res = 0, i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                i++;
            else {
                res = Math.max(res, j++ - i);
            }
        }

        return res;
    }
}
