package com.coding.leetcode.bs.monotonic;

public class SplitArrayLargestSum {

    //https://leetcode.com/problems/split-array-largest-sum/
    public static void main( String[] args ) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;

        System.out.println(splitArray(nums, m));
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    private static int splitArray( int[] nums, int m ) {
        int max = 0;
        long sum = 0, res = -1;

        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        if (m == 1)
            return (int) sum;

        //binary search
        long l = max;
        long r = sum;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (valid(mid, nums, m)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int) res;
    }

    private static boolean valid( long minReqTarget, int[] nums, int totalSubArrays ) {
        int count = 1;
        long total = 0;

        for (int num : nums) {

            total += num;

            if (total > minReqTarget) {

                //assigning total = num is required; else wrong answer
                total = num;

                count++;

                if (count > totalSubArrays) {
                    return false;
                }
            }
        }

        return true;
    }
}
