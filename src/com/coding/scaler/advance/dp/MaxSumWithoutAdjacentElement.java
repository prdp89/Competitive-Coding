package com.coding.scaler.advance.dp;

public class MaxSumWithoutAdjacentElement {

    /**
     * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
     * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
     *
     * Return the maximum possible sum.
     *
     * Note: You are allowed to choose more than 2 numbers from the grid.
     *
     * Input 1:
     *
     *  A = [
     *         [1]
     *         [2]
     *      ]
     * Input 2:
     *
     *  A = [
     *         [1, 2, 3, 4]
     *         [2, 3, 4, 5]
     *      ]
     *
     *  Output 1:
     *
     *  2
     * Output 2:
     *
     *  8
     *
     *
     *  Explanation 1:
     *
     *  We will choose 2 (From 2nd row 1st column).
     * Explanation 2:
     *
     *  We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
     */

    public static void main(String[] args) {
        int [][] A = {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
         };

        System.out.println(adjacent(A));
    }

    private static int adjacent(int[][] A) {
        int m=A[0].length;
        int[] max=new int[m];
        //convert 2 * grid into 1 * grid based on observation

        //first calculating row wise max
        for(int i=0;i<m;i++){
            A[0][i]=Math.max(A[0][i],A[1][i]);
        }

        for(int i=0;i<m;i++){
            if(i==0){
                max[0]=A[0][0];
            } else if(i==1){
                //why A[0][i]: bcz in above loop we maintain A[0][i] index as max element.
                max[i]=Math.max(max[i-1],A[0][i]);
            } else {
                //then exclude and include
                max[i]=Math.max(max[i-1],max[i-2]+A[0][i]);
            }
        }

        return max[m-1];
    }
}
