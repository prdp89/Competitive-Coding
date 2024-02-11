package com.coding.scaler.advance.dp;

public class UniquePaths {

    /**
     * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
     * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
     *
     * Now consider if some obstacles are added to the grids.
     * Return the total number unique paths from (1, 1) to (n, m).
     *
     * Note:
     * 1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
     * 2. Given Source Point and Destination points are 1-based index.
     *
     * nput 1:
     *
     *  A = [
     *         [0, 0, 0]
     *         [0, 1, 0]
     *         [0, 0, 0]
     *      ]
     *
     *
     *      Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1),
     *                                  (2, 1), (3, 1), (3, 2), (3, 3)}
     *  So, the total number of unique paths is 2.
     */
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }

    private static int uniquePathsWithObstacles(int[][] a) {
        if(a[0][0] == 1)
            return 0;

        int [][] dp = new int[a.length][a[0].length];
        dp[0][0] = 1;

        for (int i=1; i< a[0].length; i++) {
            //if we have obstacle, initial ways is zero
            if(a[0][i] == 1)
                dp[0][i] = 0;
            else dp[0][i] = dp[0][i-1];
        }

        for (int i=1; i< a.length; i++) {
            if(a[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }

        for (int i=1; i< a.length; i++) {
            for (int j=1; j< a[1].length; j++) {
                if(a[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[a.length-1][a[0].length-1];
    }
}
