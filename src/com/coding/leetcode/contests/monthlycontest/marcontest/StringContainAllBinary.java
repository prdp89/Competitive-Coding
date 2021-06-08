package com.coding.leetcode.contests.monthlycontest.marcontest;

import java.util.HashSet;

public class StringContainAllBinary {

    //https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/
    public static void main( String[] args ) {
        String s = "0000000001011100";
        int k = 4;
        System.out.println(hasAllCodes(s, k));
    }

    //Runtime: 151 ms
    //Memory Usage: 46.8 MB
    private static boolean hasAllCodes( String s, int k ) {
        int pow = 2 << (k - 1);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            int temp = Integer.parseInt(s.substring(i, i + k), 2);
            set.add(temp);
            if (set.size() == pow)
                return true;
        }

        return false;
    }
}
