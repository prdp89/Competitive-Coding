package com.coding.scaler.advance.arrays;

import java.util.Arrays;

public class MaximizeOnesLeftAndRightByFlipping {

    //This qut. is combo of AddElementToGivenRange and Kadane's Algo
    public static void main(String[] args) {
        System.out.println(Arrays.toString(flip("010")));
    }

    /**
     * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
     * In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters
     * AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
     *
     * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
     *
     * If you don't want to perform the operation, return an empty array. Else, return an array consisting
     * of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest
     * pair of L and R.
     */
    private static int[] flip(String A) {
        int sum=0;
        int max_sum = Integer.MIN_VALUE;
        int s=0,start =0,end=0;

        for(int i=0; i< A.length(); i++){

            if(A.charAt(i) == '0')
                sum = sum + 1;

            if(A.charAt(i) == '1')
                sum = sum - 1;

            if(sum > max_sum){
                end = i;
                start = s;
                max_sum = sum;
            }

            if(sum < 0){
                sum = 0;
                s = i+1;
            }
        }

        if(max_sum < 0)
            return new int[0];

        int ans[] = new int[2];

        ans[0]=start+1; ans[1] = end+1;
        return ans;
    }
}
