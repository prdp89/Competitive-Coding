package com.coding.leetcode.contests.weekely.weekely227;

public class CheckArraySortedRotated {

    //https://leetcode.com/contest/weekly-contest-227/problems/check-if-array-is-sorted-and-rotated/
    public static void main( String[] args ) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println( check(nums));
    }

    //couldnot think of it..
    private static boolean check( int[] nums ) {
        if (nums.length == 1)
            return true;

        boolean incr = nums[0] < nums[1];

        return true;
    }

    /*
    Approach:
    if array is sorted and rotated then, there is only 1 break point where (nums[x] > nums[x+1]),
    if array is only sorted then, there is 0 break point.
     */
    private static boolean checkOptimal( int[] nums ) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            //only checking this condt. is sufficient
            //If array is decreasing then only first 2 two elements are allowed [2, 1] otherwise.. false
            if (nums[i] > nums[(i + 1) % n]) {
                k++;
            }

            if (k > 1)
                return false;
        }

        return true;
    }
}
