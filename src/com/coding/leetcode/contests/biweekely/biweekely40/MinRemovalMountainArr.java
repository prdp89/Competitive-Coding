package com.coding.leetcode.contests.biweekely.biweekely40;

import java.util.Arrays;

public class MinRemovalMountainArr {

    //https://leetcode.com/contest/biweekly-contest-40/problems/minimum-number-of-removals-to-make-mountain-array/
    public static void main( String[] args ) {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums));
    }

    //Runtime: 51 ms
    //Memory Usage: 39.3 MB
    private static int minimumMountainRemovals( int[] nums ) {
        int n = nums.length;
        int[] left = new int[n]; // maximum increasing subsequence in the left of an element.
        int[] right = new int[n]; // maximum increasing subsequence in the left of an element.

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // calculating maximum increasing subsequence for the left of an index.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && left[i] < left[j] + 1)
                    left[i] = left[j] + 1;
            }
        }

        // calculating maximum increasing subsequence for the right of an index.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && right[i] < right[j] + 1)
                    right[i] = right[j] + 1;
            }
        }

        // calculating the maximum number of elements that can be involved in a mountain array.
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (right[i] > 1 && left[i] > 1) // if element nums[i] is a valid peak,
                max = Math.max(max, left[i] + right[i] - 1); //-1 bcz same element calc twice
        }

        // we need to delete the rest of the elements to calc min removals.
        return n - max;
    }
}
