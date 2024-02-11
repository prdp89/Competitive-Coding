package com.coding.scaler.advance.dp.knapsack;

public class BuyingCandies {

    /**
     * Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
     * <p>
     * The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles,
     * each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik
     * can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
     * <p>
     * Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?
     * <p>
     * Input 1:
     * <p>
     * A = [1, 2, 3]
     * B = [2, 2, 10]
     * C = [2, 3, 9]
     * D = 8
     * <p>
     * Output 1:
     * 10
     */
    public static void main(String[] args) {
        int [] pack = {1,2,3}; //A
        int [] sweetness = {2,2,10}; //B
        int [] cost = {2,3,9}; //C

        int totalMoney = 8;

        System.out.println(solve(pack, sweetness, cost, totalMoney));
    }

    private static int solve(int[] packets, int[] sweetness, int[] cost, int capacity) {
        int n = packets.length;
        int[] dp = new int[capacity + 1];

        // process all sub-arrays for all the capacities
        for (int i = 0; i < n; i++) {

            for (int s = cost[i]; s <= capacity; s++) { //only this loop differ in UnBounded knapsac
                int include = 0, exclude = 0;

                if (cost[i] <= s)
                    include = (packets[i] * sweetness[i]) + dp[s - cost[i]];

                if (i > 0)
                    exclude = dp[s];

                dp[s] = Math.max(exclude, include);
            }
        }
        return dp[capacity];
    }

}
