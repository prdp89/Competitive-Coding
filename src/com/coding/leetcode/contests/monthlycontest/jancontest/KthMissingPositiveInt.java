package com.coding.leetcode.contests.monthlycontest.jancontest;

import java.util.Arrays;

public class KthMissingPositiveInt {

    //https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;

        System.out.println(findKthPositive(arr, k));
    }

    //by me:)
    //Runtime: 1 ms, faster than 30.31% of Java
    private static int findKthPositive( int[] arr, int k ) {
        int[] count = new int[arr[arr.length - 1] + 1];
        Arrays.fill(count, -1);

        for (int item : arr) {
            count[item]++;
        }

        int end = arr[arr.length - 1];
        for (int i = 1; i <= end; i++) {
            if (count[i] == -1)
                k--;
            if (k == 0)
                return i;
        }

        return end + k;
    }

    public int findKthPositive_another_sol( int[] arr, int k ) {
        for (int i : arr) {
            if (i <= k) k++;
            else break;
        }
        return k;
    }

    public int findKthPositive_binary_search( int[] nums, int k ) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            //dragging left to a better position so that it justifies K
            if (nums[mid] - mid <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k; //same as mine logic
    }
}
