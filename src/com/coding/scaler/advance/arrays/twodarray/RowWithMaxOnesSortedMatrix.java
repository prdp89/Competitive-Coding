package com.coding.scaler.advance.arrays.twodarray;

public class RowWithMaxOnesSortedMatrix {

    public static void main(String[] args) {
        int [][] A = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 1}
        };

        System.out.println(solve(A));
    }

    /**
     * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
     *
     * NOTE:
     *
     * If two rows have the maximum number of 1 then return the row which has a lower index.
     * Rows are numbered from top to bottom and columns are numbered from left to right.
     * Assume 0-based indexing.
     * Assume each row to be sorted by values.
     * Expected time complexity is O(rows + columns).
     *
     * A = [   [0, 1, 1]
     *          [0, 0, 1]
     *          [0, 1, 1]   ]
     *
     *  Output 1:
     *
     *  0
     *
     *  Explanation 1:
     *
     *  Row 0 has maximum number of 1s.
     * @return
     */
    private static int solve(int[][] A) {
        int res = Integer.MAX_VALUE;
        int i=0, j = A[0].length-1;
        int resRow = 0;
        while(i < A.length && j >= 0) {
            if(A[i][j] == 0) {
                i++;
            } else {
                j--;
            }

            //we have to minimize j to find row with max 1's
            if(j < res) {
                res = j;
                resRow = i;
            }
        }

        return resRow;
    }
}
