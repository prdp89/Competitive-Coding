package com.coding.leetcode.contests.weekely.weekely237;

import java.util.Arrays;

public class MaxIceCreamBars {

    //https://leetcode.com/contest/weekly-contest-237/problems/maximum-ice-cream-bars/
    public static void main( String[] args ) {
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;

        System.out.println(maxIceCream(costs, coins));
    }

    //63 / 63 test cases passed.
    //Status: Accepted
    //Runtime: 32 ms
    private static int maxIceCream( int[] costs, int coins ) {
        int res = 0;
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                coins -= costs[i];
                res++;
            }
        }

        return res;
    }
}
