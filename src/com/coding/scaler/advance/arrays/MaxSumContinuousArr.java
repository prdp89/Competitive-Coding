package com.coding.scaler.advance.arrays;

public class MaxSumContinuousArr {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {1, 2, 3, 4, -10}));
    }

    private static int maxSubArray(final int[] A) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for(int item : A) {
            sum += item;
            maxSum = Math.max(sum, maxSum);
            if(sum < 0)
                sum = 0;
        }

        return maxSum;
    }
}
