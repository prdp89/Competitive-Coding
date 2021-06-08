package com.coding.leetcode.contests.weekely.weekely232;

import java.util.Arrays;

public class OneStringSwapEqual {

    //https://leetcode.com/contest/weekly-contest-232/problems/check-if-one-string-swap-can-make-strings-equal/
    public static void main( String[] args ) {
        System.out.println(areAlmostEqual("abcd", "dcba"));
    }

    //Runtime: 1 ms
    //Memory Usage: 36.9 MB
    private static boolean areAlmostEqual( String s1, String s2 ) {
        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2))
            return true;

        int[] arr1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int[] arr2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        if (!Arrays.toString(arr1).equals(Arrays.toString(arr2))) //or use Arrays.equals(arr1, arr2)
            return false;

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }

        return diff <= 2;
    }
}
