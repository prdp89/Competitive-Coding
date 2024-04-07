package com.coding.scaler.advance.greedy;

import java.util.Arrays;

public class SmallestCoinChange {

    /**
     * The monetary system in DarkLand is really simple and systematic.
     * The locals-only use coins. The coins come in different values. The values used are:
     *
     *  1, 5, 25, 125, 625, 3125, 15625, ...
     * Formally, for each K >= 0 there are coins worth 5K.
     *
     * Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item
     *
     * Input 1:
     *
     *  A = 47
     *
     *  Output 1:
     *
     *  7
     *
     *  Explanation 1:
     *
     *  Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(47));
    }

    private static int solve(int A) {
        int count = 0;

        while (A > 0) {
            int rem = A % 5;
            count += rem;
            A /= 5;
        }

        return count;
    }
}
