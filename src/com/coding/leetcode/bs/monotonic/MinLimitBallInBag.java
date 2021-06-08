package com.coding.leetcode.bs.monotonic;

public class MinLimitBallInBag {

    //https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
    //https://leetcode.com/contest/weekly-contest-228/problems/minimum-limit-of-balls-in-a-bag/
    public static void main( String[] args ) {
        int[] nums = {2, 4, 8, 2};
        int op = 4;

        System.out.println(minimumSize(nums, op));
    }

    private static int minimumSize( int[] nums, int maxOperations ) {
        int low = 1, high = (int) 1e9, res = -1;

        //search space is 1 -- 10^9
        while (low <= high) {
            int mid = (low + high) / 2;
            long need = 0;

            for (int item : nums) {
                need += getCost(item, mid);
            }

            if (need <= maxOperations) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    private static long getCost( int val, int maxAllow ) {
        int quo = val / maxAllow;
        int rem = val % maxAllow;
        return quo + (rem == 0 ? -1 : 0);
    }
}
