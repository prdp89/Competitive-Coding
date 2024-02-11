package com.coding.scaler.advance.dp.knapsack;

public class RodCutting {

    public static void main(String[] args) {
        System.out.println(solveBottomUp_DP(new int[] {3, 4, 1, 6, 2}));
    }

    private static int solveBottomUp_DP(int[] pieceProfit ) {
        int [] dp = new int[pieceProfit.length+1];

        for (int i = 0; i <= pieceProfit.length; i++) {

            //i+1: to start from cut of length 1
            for (int cut = i+1; cut <= pieceProfit.length; cut++) {

                int exclude = dp[cut];
                int include = 0;

                if(i <= cut) {
                    //cut - i - 1 = to include first calculated value
                  include =  dp[cut - i - 1] + pieceProfit[i];
                }

                dp[cut] = Math.max(include, exclude);
            }
        }

        return dp[pieceProfit.length];
    }
}
