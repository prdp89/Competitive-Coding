package com.coding.scaler.advance.arrays.twodarray;

public class MaxSubMatrixSum {

    /**
     * Given a row-wise and column-wise sorted matrix A of size N * M.
     * Return the maximum non-empty submatrix sum of this matrix.
     *
     * Input 1:-
     *     -5 -4 -3
     * A = -1  2  3
     *      2  2  4
     *
     * Output 1:-
     * 12
     *
     * Expanation 1:-
     * The submatrix with max sum is
     * -1 2 3
     *  2 2 4
     *
     *  Sum is 12.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {-5, -4, -3},
                {-1,  2,  3},
                {2,  2,  4},
        })
        );
    }

    private static long solve(int[][] A) {
        int n = A.length, m = A[0].length;
        long p[][] = new long[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                p[i][j] = A[i][j];
            }
        }

        // step 1: Row wise prefix
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-2; j >= 0; j--)
            {
                p[i][j] = p[i][j+1] + p[i][j];
            }
        }

        // step 2. Col wise prefix
        for(int j=m-1; j>=0; j--)
        {
            for(int i=n-2; i>=0; i--)
            {
                p[i][j] = p[i+1][j] + p[i][j];
            }
        }

        long ans = A[n-1][m-1];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j >= 0; j--)
            {
                ans = Math.max(p[i][j], ans);
            }
        }

        return ans;
    }
}
