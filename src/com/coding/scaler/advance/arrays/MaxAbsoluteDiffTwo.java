package com.coding.scaler.advance.arrays;

public class MaxAbsoluteDiffTwo {

    /**
     * Given 4 array of integers A, B, C and D of same size, find and return the maximum value of
     * | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|
     * where i != j and |x| denotes the absolute value of x.
     */
    public static void main(String[] args) {
        System.out.println(solve(
                new int[] {1, 2, 3, 4},
                new int[] {-1, 4, 5, 6},
                new int[] {-10, 5, 3, -8},
                new int[] {-1, -9, -6, -10}
        ));
    }

    //Refer below link for similar approach/questions:
    //https://dcga8ozhbq5np.cloudfront.net/original/2X/f/f742c04ce37a0dd6765bd72d56a99d425efff558.jpeg
    private static int solve(int[] A, int[] B, int[] C, int[] D) {
        int [] sign = {1, -1};
        int res = Integer.MIN_VALUE;

        for(int a = 0; a < 2; a++) {

            for(int b = 0; b < 2; b++) {

                for(int c = 0; c < 2; c++) {

                    for(int d = 0; d < 2; d++) {

                        int maxSum = Integer.MIN_VALUE;
                        int minSum = Integer.MAX_VALUE;
                        int sum = 0;

                        for(int i=0; i < A.length; i++) {
                            sum = sign[a] * A[i] + sign[b] * B[i] + sign[c] * C[i] + sign[d] * D[i] + i;
                            maxSum = Math.max(maxSum, sum);
                            minSum = Math.min(minSum, sum);

                            res = Math.max(res, maxSum - minSum);
                        }
                    }
                }
            }
        }

        return res;
    }
}
