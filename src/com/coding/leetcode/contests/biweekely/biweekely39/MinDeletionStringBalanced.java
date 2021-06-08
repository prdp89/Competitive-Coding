package com.coding.leetcode.contests.biweekely.biweekely39;

public class MinDeletionStringBalanced {

    //https://leetcode.com/contest/biweekly-contest-39/problems/minimum-deletions-to-make-string-balanced/
    public static void main( String[] args ) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    //https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/discuss/935701/DP-solution-beats-100-with-explanation
    //similar question: https://leetcode.com/problems/flip-string-to-monotone-increasing/
    private static int minimumDeletions( String s ) {
        int countB = 0, res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') //bcz String can be ab, so either increased res is min or the countB
                res = Math.min(++res, countB);
            else if (ch == 'b')
                countB++;
        }

        return res;
    }
}
