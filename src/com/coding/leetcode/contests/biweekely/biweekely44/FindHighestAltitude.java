package com.coding.leetcode.contests.biweekely.biweekely44;

public class FindHighestAltitude {

    //https://leetcode.com/contest/biweekly-contest-44/problems/find-the-highest-altitude/
    public static void main( String[] args ) {
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    private static int largestAltitude( int[] gain ) {
        int res = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            res = Math.max(res, sum);
        }

        return Math.max(res, 0);
    }
}
