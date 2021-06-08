package com.coding.leetcode.contests.weekely.weekely228;

public class MinChangesAlterStr {

    //https://leetcode.com/contest/weekly-contest-228/problems/minimum-changes-to-make-alternating-binary-string/
    public static void main( String[] args ) {
        String s = "10";
        System.out.println(minOperations(s));
        System.out.println(minOperationsOptimal(s));
    }

    //48/90 tests passed
    private static int minOperations( String s ) {
        if (s.length() == 1)
            return 0;

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res++;
                i++;
            }
        }

        return res;
    }

    private static int minOperationsOptimal( String s ) {
        if (s.length() == 1)
            return 0;

        int res = 0, res1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                res++;
            } else
                res1++;
        }

        return Math.min(res, res1);

        /*
        int res = 0;
        // 010101...
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != '0') res++;
        }
        // 101010...
        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != '1') res++;
        }
         */
    }
}
