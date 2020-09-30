package com.coding.leetcode.contests.weekely.weekely208;

public class MaxProfitCentennial {

    //https://leetcode.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
    public static void main( String[] args ) {
        int[] customer = {8, 3};
        int boardingCost = 5, runningCost = 6;

        System.out.println(minOperationsMaxProfit(customer, boardingCost, runningCost));
        System.out.println(minOperationsMaxProfit_optimal(customer, boardingCost, runningCost));
    }

    //only 5 tests passed :(
    private static int minOperationsMaxProfit( int[] customers, int boardingCost, int runningCost ) {

        int maxProfit = Integer.MIN_VALUE, maxIndex = -1, remaining = 0, tAllowed = 0;

        int i = 0;
        for (; i < customers.length; i++) {
            remaining += customers[i] - 4;

            int allowed = remaining >= 0 ? 4 : customers[i];
            tAllowed += allowed;

            int cost = tAllowed * boardingCost - ((i + 1) * runningCost);
            if (cost > maxProfit) {
                maxProfit = cost;
                maxIndex = i + 1;
            }
        }

        while (remaining > 0) {
            int temp = remaining - 4;

            int allowed = temp >= 0 ? 4 : remaining;
            tAllowed += allowed;

            int cost = tAllowed * boardingCost - ((i + 1) * runningCost);
            if (cost > maxProfit) {
                maxProfit = cost;
                maxIndex = i + 1;
            }

            remaining -= 4;
        }

        return maxIndex;
    }

    private static int minOperationsMaxProfit_optimal( int[] customers, int boardingCost, int runningCost ) {

        int c = 0, rem = 0, r = 0, p_max = -1, ans = -1;

        for (int i = 0; i < customers.length || (rem > 0); i++) {

            r++;
            rem += i < customers.length ? customers[i] : 0;

            if (rem < 4) {
                c += rem;
                rem = 0;
            } else {
                c += 4;
                rem -= 4;
            }

            int p = c * boardingCost - r * runningCost;
            if (p > p_max) {
                p_max = p;
                ans = r;
            }
        }

        return p_max < 0 ? -1 : ans;
    }
}
