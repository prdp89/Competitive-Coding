package com.coding.leetcode.contests.biweekely.biweekely41;

import java.util.Arrays;

public class SumAbsDiffSortArr {

    //https://leetcode.com/contest/biweekly-contest-41/problems/sum-of-absolute-differences-in-a-sorted-array/
    public static void main( String[] args ) {
        int[] nums = {2, 3, 5};
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    //explanation:https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/discuss/969761/Illustrations-for-O(n)-formula-Java-Kotlin-Python
    private static int[] getSumAbsoluteDifferences( int[] nums ) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];

            int fromLeft = nums[i] * i - left;
            int fromRight = right - (nums.length - i - 1) * nums[i];

            result[i] = fromLeft + fromRight;

            left += nums[i];
        }

        return result;
    }
}
