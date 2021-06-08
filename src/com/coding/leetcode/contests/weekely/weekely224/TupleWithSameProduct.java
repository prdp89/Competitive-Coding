package com.coding.leetcode.contests.weekely.weekely224;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

    //https://leetcode.com/contest/weekly-contest-224/problems/tuple-with-same-product/
    public static void main( String[] args ) {
        int[] nums = {2, 3, 4, 6};
        System.out.println(tupleSameProduct(nums));
    }

    //Runtime: 212 ms, faster than 98.17%
    private static int tupleSameProduct( int[] nums ) {
        int res = 0;
        Map<Integer, Integer> mulFreq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int prod = nums[i] * nums[j];
                int c = mulFreq.getOrDefault(prod, 0);
                res += c; //Number of valid pair of pairs.

                mulFreq.put(prod, c + 1);
            }
        }

        return res * 8; //Each tuple [a,b,c,d] can be arranged in 8 different ways matching the criteria.
    }
}
