package com.coding.leetcode.contests.weekely.weekely238;

import java.util.Arrays;

public class FreqOfMostFreqElement {

    //https://leetcode.com/contest/weekly-contest-238/problems/frequency-of-the-most-frequent-element/
    public static void main( String[] args ) {
        int[] nums = {1, 2, 4};
        int k = 5;

        System.out.println(maxFrequency(nums, k));
    }

    //https://leetcode.com/problems/frequency-of-the-most-frequent-element/
    //Runtime: 26 ms, faster than 73.25% of Java
    private static int maxFrequency( int[] nums, int k ) {
        Arrays.sort(nums);
        int left = 0, right = 1, incrementRequired = 0;

        for (; right < nums.length; right++) {
            incrementRequired += (nums[right] - nums[left]) * (right - left);

            // if increment required become greater than k, then,
            // reduce the increments required to get nums[left] to nums[right] & slide left pointer forward
            if (incrementRequired > k)
                incrementRequired -= (nums[right] - nums[left++]);
        }

        return right - left;
    }
}
