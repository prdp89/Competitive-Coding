package com.coding.leetcode.bs.trialerror;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/

    //just take overview: https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
    public static void main( String[] args ) {
        int[] arr = {1, 3, 1};

        System.out.println(smallestDistancePair(arr, 1));
    }

    //Runtime: 7 ms, faster than 38.45% of Java
    private static int smallestDistancePair( int[] nums, int k ) {
        Arrays.sort(nums);

        int n = nums.length;

        //L and R defines search space
        int l = 0;
        int r = nums[n - 1] - nums[0];

        for (int cnt = 0; l < r; cnt = 0) {
            int m = l + (r - l) / 2;

            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] <= nums[i] + m) j++;
                cnt += j - i - 1;
            }

            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
