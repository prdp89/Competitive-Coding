package com.coding.leetcode.contests.weekely.weekely230;

import java.util.PriorityQueue;

public class EqualSumMinOperations {

    //https://leetcode.com/contest/weekly-contest-230/problems/equal-sum-arrays-with-minimum-number-of-operations/
    public static void main( String[] args ) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 1, 2, 2, 2, 2};

        System.out.println(minOperations(nums1, nums2));
    }

    private static int minOperations( int[] nums1, int[] nums2 ) {
        if (nums1.length > 6 * nums2.length || nums2.length > 6 * nums1.length)
            return -1;

        int sum1 = 0, sum2 = 0;
        for (int item : nums1)
            sum1 += item;

        for (int item : nums2)
            sum2 += item;

        if (sum1 > sum2) //if sum1 > sum2; recur for swap operation purpose only
            return minOperations(nums2, nums1);

        //Now Nums1 element sum smaller than Nums2 for adding in Min-PQ
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int item : nums1)
            pq1.offer(item);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(( a, b ) -> b - a);
        for (int item : nums2) //now nums2 array values are nums1 {{1, 2, 3, 4, 5, 6}} bzc it is greater
            pq2.offer(item);

        int res = 0;
        //go until sum1 < sum2; otherwise the nums are equal
        while (sum1 < sum2) {
            if(pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek()) {
                sum1 += 6 - pq1.poll(); //bcz sum1 is smaller giving it change to pick greedily
            } else {
                sum2 -= pq2.poll() - 1;
            }

            res++;
        }

        return res;
    }
}
