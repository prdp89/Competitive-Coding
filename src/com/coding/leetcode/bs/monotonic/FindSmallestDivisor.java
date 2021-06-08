package com.coding.leetcode.bs.monotonic;

public class FindSmallestDivisor {

    //https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
    public static void main( String[] args ) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }

    //Runtime: 31 ms, faster than 12.81% of Java
    private static int smallestDivisor( int[] nums, int threshold ) {
        int start = 1, end = 1000000, ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (sumOfDivision(mid, nums) <= threshold) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private static int sumOfDivision( int mid, int[] nums ) {
        int sum = 0;
        for (int item : nums) {
            sum += (int) Math.ceil((double) item / mid);
        }

        return sum;
    }
}
