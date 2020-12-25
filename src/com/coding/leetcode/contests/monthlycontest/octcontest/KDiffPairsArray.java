package com.coding.leetcode.contests.monthlycontest.octcontest;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsArray {

    //https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
    public static void main( String[] args ) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;

        System.out.println(findPairs(nums, k));
    }

    //Runtime: 8 ms, faster than 68.98% of Java
    private static int findPairs( int[] nums, int k ) {
        if (k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int item : nums)
            map.put(item, map.getOrDefault(item, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //edge case
            if (k == 0) {
                if (entry.getValue() >= 2)
                    res++;
            } else {
                if (map.containsKey(entry.getKey() + k))
                    res++;
            }
        }

        return res;
    }
}
