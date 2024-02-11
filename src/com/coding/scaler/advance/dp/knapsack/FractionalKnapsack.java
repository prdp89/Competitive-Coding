package com.coding.scaler.advance.dp.knapsack;

import java.util.Arrays;

public class FractionalKnapsack {

    /**
     * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
     *
     * Also given an integer C which represents knapsack capacity.
     *
     * Find out the maximum total value that we can fit in the knapsack.
     * If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
     *
     * NOTE:
     *
     * You can break an item for maximizing the total value of the knapsack
     *
     * Input 1:
     *
     *  A = [60, 100, 120]
     *  B = [10, 20, 30]
     *  C = 50
     *
     *  Output 1:
     *
     *  24000
     *
     * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
     * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
     */
    public static void main(String[] args) {
        int [] a = {60, 100, 120};
        int [] b = {10, 20, 30};
        int c =50;
        System.out.println(solve(a, b, c));
    }

    private static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        Item[] items = new Item[n];

        for (int i=0; i<n; i++) {
            items[i] = new Item(A[i], B[i], A[i] / B[i]);
        }

        Arrays.sort(items, (i, j) -> Double.compare(j.ratio, i.ratio));
        double ans = 0;
        for (int i=0; i<n; i++) {
            if(items[i].weight <= C) {
                C -= items[i].weight;
                ans+=items[i].val;
            } else {
                ans = ans + C * items[i].ratio;
                break;
            }
        }
        return (int)(ans * 1000) / 10;
    }

    static class Item {
        int val;
        int weight;
        double ratio;

        Item(int val, int weight, double ratio) {
            this.val = val;
            this.weight = weight;
            this.ratio = ratio;
        }
    }
}
