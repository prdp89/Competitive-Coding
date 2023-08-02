package com.coding.scaler.advance.arrays.twodarray;

import java.util.Arrays;

public class SubmatrixSumWithQueries {

    /**
     * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
     *
     * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
     *
     * NOTE:
     *
     * Rows are numbered from top to bottom, and columns are numbered from left to right.
     * The sum may be large, so return the answer mod 109 + 7.
     * Also, select the data type carefully, if you want to store the addition of some elements.
     * Indexing given in B, C, D, and E arrays is 1-based.
     * Top Left 0-based index = (B[i] - 1, C[i] - 1)
     * Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solve(new int[][]{ {1, 2, 3},
                {4,5,6},
                {7,8,9}},
                new int[] {1, 2},
                new int[] {1,2},
                new int[] {2, 3},
                new int[] {2,3})
        ));
    }

    //Main prefix formula for submatriz sum:
    //pf(i,j) = pf(a2, b2) - pf(a2, b1-1) - pf(a1-1, b2) + pf(a1-1, b1-1)

    /**
     *  A = [   [1, 2, 3]
     *          [4, 5, 6]
     *          [7, 8, 9]   ]
     *  B = [1, 2]
     *  C = [1, 2]
     *  D = [2, 3]
     *  E = [2, 3]

     Output 1:

     [12, 28]

     Explanation 1:
     For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
     For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.

     * @return
     */
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length;
        int m = A[0].length;

        //doesn;t works updating the same array
        /*for(int i=0; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                A[i][j] = A[i][j] + A[i][j-1];
            }
        }

        for(int j=0; j<cols; j++) {
            for (int i =1; i<rows; i++) {
                A[i][j] = A[i][j] + A[i-1][j];
            }
        }*/

        long p[][] = new long[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                p[i][j] = A[i][j];
            }
        }

        // step 1: Row wise prefix
        for(int i=0; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                p[i][j] = p[i][j-1] + p[i][j];
            }
        }

        // step 2. Col wise prefix
        for(int j=0; j<m; j++)
        {
            for(int i=1; i<n; i++)
            {
                p[i][j] = p[i-1][j] + p[i][j];
            }
        }

        long mod = 1000000007;
        int [] res = new int[B.length];

        for(int i=0; i<B.length; i++) {
            int a1 = B[i]-1, b1 = C[i]-1, a2 = D[i]-1, b2 = E[i]-1;

            long sum = p[a2][b2];

            if(a1 > 0 && b1 > 0)
                sum = (sum + p[a1-1][b1-1])% mod;

            if(a1 > 0) {
                sum = (sum - p[a1-1][b2]) % mod;
            }

            if(b1 > 0) {
                sum = (sum - p[a2][b1-1]) % mod;
            }

            if(sum < 0){
                sum = (sum + mod) % mod;
            }

            res[i] = (int)sum;
        }

        return res;
    }
}
