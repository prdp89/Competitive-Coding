package com.coding.leetcode.contests.biweekely.biweekely45;

public class MinLengthStringsDeletingEnds {

    //https://leetcode.com/contest/biweekly-contest-45/problems/minimum-length-of-string-after-deleting-similar-ends/
    public static void main( String[] args ) {
        System.out.println(minimumLength("ca"));
    }

    private static int minimumLength( String s ) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);
            while (i <= j && s.charAt(i) == ch)
                ++i;

            while (i <= j && s.charAt(j) == ch)
                --j;
        }

        return i > j ? 0 : j - i + 1;
    }
}
