package com.coding.scaler.hashing;

import java.util.HashSet;

public class SubArrayZeroSum {

    public static void main(String[] args) {
        System.out.println(solveOptimal(new int[] {4, -1, 1}));
    }

    //brute force
    public int solve(int[] arr) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        for(int i=0; i<arr.length; i++) {

            int sum = 0;
            for(int j= i; j<arr.length; j++) {
                sum += arr[j];

                if(sum == 0)
                    return 1;
            }
        }

        return 0;
    }

    public static int solveOptimal(int[] arr) {
        int n = arr.length;
        HashSet<Long> hs = new HashSet<>();

        Long sum = 0L;
        for (int i=0; i< n; i++) {
            sum += arr[i];

            //if hs contains the prev sum that means sum of elements are zero
            if(sum == 0 || hs.contains(sum))
                return 1;

            hs.add(sum);
        }

        return 0;



    }
}
