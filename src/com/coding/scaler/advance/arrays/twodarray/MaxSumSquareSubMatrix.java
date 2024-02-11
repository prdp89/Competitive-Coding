package com.coding.scaler.advance.arrays.twodarray;

public class MaxSumSquareSubMatrix {

    /**
     * Given a 2D integer matrix A of size N x N,
     * find a B x B submatrix where B<= N and B>= 1,
     * such that the sum of all the elements in the submatrix is maximum.
     *
     * Input 1:
     *
     *  A = [
     *         [1, 1, 1, 1, 1]
     *         [2, 2, 2, 2, 2]
     *         [3, 8, 6, 7, 3]
     *         [4, 4, 4, 4, 4]
     *         [5, 5, 5, 5, 5]
     *      ]
     *  B = 3
     *
     *  Output 1:
     *
     *  48
     *
     *  Explanation 1:
     *
     *     Maximum sum 3 x 3 matrix is
     *     8 6 7
     *     4 4 4
     *     5 5 5
     *     Sum = 48
     * @param args
     */
    public static void main(String[] args) {
        int [][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int B = 3;

        System.out.println( solveBF(A, B));

        System.out.println(solveDP(A, B));
    }

    private static int solveDP(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;

        int res = Integer.MIN_VALUE;
        int [][] dp = new int[row+1][col+1];

        //calculating sum of elements till ith element of matrix
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[i].length; j++) {
                dp[i][j] = A[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]; // dp[i-1][j-1] added twice on dp[i-1][j] + dp[i][j-1]
            }
        }

        for (int i=1; i<dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int sum = Integer.MIN_VALUE;
                if(i-B >= 0 && j-B >= 0) {
                    //this is called extracting the square matrix from DP array
                    sum = dp[i][j] - dp[i-B][j] - dp[i][j-B] + dp[i-B][j-B];
                    res = Math.max(sum, res);
                }
            }
        }

        return res;
    }

    private static int solveBF(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;

        int res = Integer.MIN_VALUE;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(i+B <= row && j + B <= col ) {

                    int sum = 0;
                    for(int k=i; k < i+B; k++) {
                        for(int l=j; l < j+B; l++) {
                            sum+=A[k][l];
                        }
                    }

                    res = Math.max(res, sum);
                }
            }
        }

        return res;
    }
}
