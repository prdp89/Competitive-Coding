package com.coding.scaler.advance.arrays.twodarray;

public class SumAllSubMatrices {

    //similar to SumAllSubArrays
    public static void main(String[] args) {
        System.out.println(solve(new int[][] {
                {1,1},
                {1,1}
        })
        );
    }

    /**
     * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
     *
     * For each A[i][j] calculating it Top-left, Bottom right:
     * Top-left: (j+1)*(i+1)
     * Bottom-Right: (m-j)*(n-i)
     *
     * Then multiply: TL * BR * A[i][j]
     * */
    private static int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int sum = 0;
        for(int i =0; i<rows; i++) {
            for(int j =0; j<cols; j++) {
                int freq = (i+1)*(j+1)*(rows-i)*(cols-j);
                sum += freq * A[i][j];
            }
        }

        return sum;
    }
}
