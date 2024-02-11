package com.coding.scaler.advance.dp.knapsack;

import java.util.Arrays;

public class BirthdayParty {

    /**
     * As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at
     * TGI Fridays in Pune. Given are the eating capacity of each friend,
     * filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of
     * the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such
     * that all of Tushar's friends are satisfied (reached their eating capacity).
     *
     * NOTE:
     *
     * Each dish is supposed to be eaten by only one person. Sharing is not allowed.
     *
     * Each friend can take any dish unlimited number of times.
     *
     * There always exists a dish with filling capacity 1 so that a solution always exists.
     *
     * Input 1:
     *
     * A = [2, 4, 6]
     * B = [2, 1, 3]
     * C = [2, 5, 3]
     *
     * Output 1:
     *
     * 12
     *
     *
     * Explanation 1:
     *
     * First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
     * So 2 + 2*2 + 3*2 = 12.
     */
    public static void main(String[] args) {
        int [] A = {2, 4, 6};
        int [] B = {2, 1, 3};
        int [] C = {2, 5, 3};

         System.out.println( solve(A, B, C));
    }

    private static int solve( int[] A,  int[] B,  int[] C) {
        int totalCost = 0;

        // Find the max of Array A
        int maxA = A[0];
        for(int i=1;i<A.length;i++){
            maxA = Math.max(maxA, A[i]);
        }

        // Create dp array of size maxA+1, so that it will store the min cost for all the eating capacities
        int[] dp = new int[maxA+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // When eating capacity is 0 then cost will be 0
        for(int i=0; i< B.length; i++){

            int dishFilling = B[i];
            int dishCost = C[i];

            //iterate from current to max dish filling a person can have
            for(int j= dishFilling; j <= maxA ; j++){

                int include = 0, exclude = dp[j];

                if(dishFilling <= j)
                    include = dp[j - dishFilling] != Integer.MAX_VALUE ? dp[j - dishFilling] + dishCost : dp[j];

                dp[j] = Math.min(include, exclude);
            }
        }

        // Find minimum cost for each filling capacities and add it to total cost
        for(int i=0; i<A.length; i++){
            totalCost += dp[A[i]];
        }

        return totalCost;
    }
}
