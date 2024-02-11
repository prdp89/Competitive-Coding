package com.coding.scaler.arrays.sorting;

import java.util.Arrays;

public class NobelIntegerInArray {

    /**
     * Given an integer array A, find if an integer p exists in the array such
     * that the number of integers greater than p in the array equals p.
     *
     * Input 1:
     *
     *  A = [3, 2, 1, 3]
     *
     *  Output 1:
     *
     *  1
     *
     *  For integer 2, there are 2 greater elements in the array.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int [] {3, 2, 1, 3}));
    }

    private static int solve(int[] A) {
        int n = A.length, count = 0;
        Arrays.sort(A);

        //if last element is zero, then return 1. since count of zero equals to zero only.
        if(A[n-1]==0){
            return 1;
        }

        for(int i=0; i < n-1; i++) {

            //A[i] != A[i+1] : for cases: 4 5 5 5 5 5
            if(A[i] != A[i+1]) {
                //eg: 4 5 6 7 8 9 10
                //number of element greater than 5 on its right equals to 5; so find it using n - i - 1
                count = n - i - 1;
            }

            if(count == A[i])
                return 1;
        }

        return -1;
    }
}
