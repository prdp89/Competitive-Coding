package com.coding.leetcode.contests.weekely.weekely231;

public class BinaryAtMostOneSegment {

    //https://leetcode.com/contest/weekly-contest-231/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
    public static void main( String[] args ) {
        System.out.println(checkOnesSegment("1001"));
    }

    private static boolean checkOnesSegment( String s ) {
        if (s.length() == 0)
            return false;
        else if (s.length() == 1) {
            return s.charAt(0) == '1';
        }

        int seg = 0, ones = 0, i = 0;
        for (; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                seg++;
                ones++;
                while (i < s.length() && s.charAt(i) != '0') {
                    i++;
                }
            }
        }

        return ones == 1 || seg == 1;
    }
}
