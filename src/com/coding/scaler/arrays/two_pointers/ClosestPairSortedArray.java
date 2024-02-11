package com.coding.scaler.arrays.two_pointers;

import java.util.Arrays;

public class ClosestPairSortedArray {

    /**
     * Given two sorted arrays of distinct integers, A and B, and an integer C,
     * find and return the pair whose sum is closest to C and the pair has one element from each array.
     *
     * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
     *
     * If there are multiple solutions find the one with minimum i and even
     * if there are multiple values of j for the same i then return the one with minimum j.
     *
     * Return an array with two elements {A[i], B[j]}.
     *
     * https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
     *
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5]
     *  B = [2, 4, 6, 8]
     *  C = 9
     *
     *  Output 1:
     *
     *  [1, 8]
     *
     *  Explanation 1:
     *
     *  There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
     *  Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {1, 2, 3, 4, 5},
                new int[] {2, 4, 6, 8}, 9)));
    }

    private static int[] solve(int[] ar1, int[] ar2, int x) {
        int diff = Integer.MAX_VALUE;

        int l = 0, r = ar2.length-1, m = ar1.length;
        int res_l = 0, res_r = 0;
        while (l<m && r>=0)
        {
            int currDiff = Math.abs(ar1[l] + ar2[r] - x);
            // If this pair is closer to x than the previously
            // found closest, then update res_l, res_r and diff
            if (currDiff < diff
            || (diff == currDiff && l <= res_l && r  <= res_r))
            {
                res_l = l;
                res_r = r;
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }

            // If sum of this pair is more than x, move to smaller
            // side
            if (ar1[l] + ar2[r] > x)
                r--;
            else  // move to the greater side
                l++;
        }
        return new int[] {ar1[res_l], ar2[res_r]};
    }
}
