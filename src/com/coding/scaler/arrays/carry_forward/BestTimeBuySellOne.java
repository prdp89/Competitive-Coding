package com.coding.scaler.arrays.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeBuySellOne {

    /**
     * Say you have an array, A, for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Return the maximum possible profit.
     * <p>
     * A = [1, 4, 5, 2, 4]
     * Output 2:
     * 4
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 4));

        System.out.println(maxProfit(list));
    }

    private static int maxProfit(List<Integer> list) {
        if (list.size() == 0)
            return 0;
        int max_profit = list.get(0), ans = 0;

        for (int i = 1; i < list.size(); i++) {

            if (max_profit > list.get(i))
                max_profit = list.get(i);

            if (list.get(i) - max_profit > ans)
                ans = list.get(i) - max_profit;
        }

        return ans;
    }
}
