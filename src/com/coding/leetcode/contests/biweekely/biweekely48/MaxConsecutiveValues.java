package com.coding.leetcode.contests.biweekely.biweekely48;

import java.util.Arrays;

public class MaxConsecutiveValues {

    //https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
    //https://leetcode.com/contest/biweekly-contest-48/problems/maximum-number-of-consecutive-values-you-can-make/
    public static void main( String[] args ) {
        int[] coins = {1, 3};
        System.out.println(getMaximumConsecutive(coins));
    }

    //We have to make values 0..N where i is the sum of coins taken from array.
    private static int getMaximumConsecutive( int[] coins ) {
        Arrays.sort(coins);
        int res = 1;
        for (int a : coins) {

            //if next coin is greater than accumulated coin so it can't participated in result..
            if (a > res)
                break;

            res += a;
        }

        return res;
    }
}
