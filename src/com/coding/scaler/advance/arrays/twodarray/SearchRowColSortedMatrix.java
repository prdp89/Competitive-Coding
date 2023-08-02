package com.coding.scaler.advance.arrays.twodarray;

public class SearchRowColSortedMatrix {

    public static void main(String[] args) {
        System.out.println( solve(new int[][]{
                {1, 2, 3},
                {4,5,6},
                {7,8,9}
        }, 2)
        );
    }

    /**
     * Given a matrix of integers A of size N x M and an integer B.
     * In the given matrix every row and column is sorted in non-decreasing order.
     * Find and return the position of B in the matrix in the given form:
     * If A[i][j] = B then return (i * 1009 + j)
     * If B is not present return -1.
     *
     * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
     * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
     * Note 3: Expected time complexity is linear
     * Note 4: Use 1-based indexing
     *
     *
     * Input 1:-
     * A = [[1, 2, 3]
     *      [4, 5, 6]
     *      [7, 8, 9]]
     * B = 2
     *
     * Output 1:-
     * 1011
     *
     * Expanation 1:-
     * A[1][2] = 2
     * 1 * 1009 + 2 = 1011
     *
     *
     * Time: O(M + N)
     */
    private static int solve(int[][] A, int B) {
        int rows = A.length, cols = A[0].length;
        int i = rows-1, j = 0;

        boolean isFound = false;
        int row =0, col=0;

        while(i >= 0 && j < cols) {
            if(A[i][j] == B) {
                row = i;
                col = j;
                isFound = true;
                i--;
            } else if(A[i][j] < B) {
                j++;
            } else {
                i--;
            }
        }

        if(isFound) {
            return ((row+1) * 1009) + (col+1);
        }

        return -1;
    }
}
