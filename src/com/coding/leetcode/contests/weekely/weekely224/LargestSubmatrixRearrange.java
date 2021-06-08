package com.coding.leetcode.contests.weekely.weekely224;

import java.util.Arrays;

public class LargestSubmatrixRearrange {

    //https://leetcode.com/problems/largest-submatrix-with-rearrangements/
    public static void main( String[] args ) {
        int[][] matrix = {
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        };

        System.out.println(largestSubmatrix(matrix));
    }

    //similar to : https://leetcode.com/problems/largest-rectangle-in-histogram/

    /*  build the matrix to:
				 [ [1, 0, 1, 1]                                      [ [1, 0, 1, 1]
				   [1, 0, 1, 0]                   -->                  [2, 0, 2, 0]
				   [0, 1, 1, 0] ]                                      [0, 1, 3, 0] ]
    */
    //Then we need to calc max for each row after the rearrangement.
    private static int largestSubmatrix( int[][] matrix ) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            // sort the Array : e.g. from [2,3,0, 1, 2,3] to [0,1,2,2,3,3]
            Arrays.sort(matrix[i]);
            for (int j = 1; j <= matrix[0].length; j++) {
                //start from matrix[0].length - j: bcz max value stays at last after sorting..
                count = Math.max(count, j * matrix[i][matrix[0].length - j]);
            }
        }

        return count;
    }
}
