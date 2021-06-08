package com.coding.leetcode.contests.biweekely.biweekely39;

import java.util.Arrays;
import java.util.HashMap;

public class DistributeRepeatingInt {

    //https://leetcode.com/contest/biweekly-contest-39/problems/distribute-repeating-integers/
    public static void main( String[] args ) {
        int[] nums = {1, 2, 3, 3}, quantity = {2};
        System.out.println(canDistribute(nums, quantity));
    }

    /*
    However, let's do a simple "transformation", it will immediately become much clearer:

    In any case, the first thing we have to do, is counting the frequency of each number in nums.
    We don't care about what the numbers are, but only the quantity.

    For any number, if the quantity of it is >= a customer's order, we can distribute the number to that customer.

    We want to figure out if we can satisfy all customers.
     */

    //Runtime: 120 ms, faster than 45.38% of Java
    private static boolean canDistribute( int[] nums, int[] quantity ) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int j = 0;
        int[] cnt = new int[map.size()];
        for (int i : map.values())
            cnt[j++] = i;

        Arrays.sort(quantity);
        // sort the quantity list in descending order -
        // once we find the biggest order left cannot be satisfied,
        // it fails, we don't need to worry about the rest
        // (otherwise it will go TLE).

        return canAssign(quantity.length - 1, cnt, quantity);
    }

    private static boolean canAssign( int at, int[] cnt, int[] quantity ) {
        if (at < 0) return true;

        for (int i = 0; i < cnt.length; i++)

            //we have to provide the quantity items atleast to satisfy the orders
            if (cnt[i] >= quantity[at]) {

                cnt[i] -= quantity[at];
                if (canAssign(at - 1, cnt, quantity)) return true;

                //backtrack..
                cnt[i] += quantity[at];
            }

        return false;
    }
}
