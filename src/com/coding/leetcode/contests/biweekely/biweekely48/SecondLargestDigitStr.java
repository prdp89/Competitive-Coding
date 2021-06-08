package com.coding.leetcode.contests.biweekely.biweekely48;

import java.util.TreeSet;

public class SecondLargestDigitStr {

    //https://leetcode.com/contest/biweekly-contest-48/problems/second-largest-digit-in-a-string/
    public static void main( String[] args ) {
        String s = "dfa11111afd";
        System.out.println(secondHighest(s));
    }

    //Runtime: 3 ms
    //Memory Usage: 37.4 MB
    private static int secondHighest( String s ) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int val = s.charAt(i) - '0';
                set.add(val);
                max = Math.max(val, max);
            }
        }

        return set.lower(max) == null ? -1 : set.lower(max);
    }
}
