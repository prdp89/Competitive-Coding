package com.coding.scaler.arrays.sliding_window.leetcode;

public class binarySubArraysum {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    //this is BF, optimal already in leetcode.
    private static int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {

            count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1)
                    count++;

                if (count == goal) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
