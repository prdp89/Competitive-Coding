package com.coding.scaler.arrays.sorting;

import java.util.Arrays;

public class NumsGreaterThanp {

    /*
    Given an integer array A, find if an integer p exists in the array such
    that the number of integers greater than p in the array equals p.

     A = [3, 2, 1, 3]

    Output: 1

     */
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 2, 1, 3}));
    }

    private static int solve(int[] A) {
        int n = A.length, count = 0;
        Arrays.sort(A);

        //for a test case: [-6,-4,-2,-1,0]
        //last element is greatest of left element, so return 1.
        if (A[n - 1] == 0) {
            return 1;
        }

        if (n > 0) {
            for (int i = n - 2; i >= 0; i--) {
                if (A[i] != A[i + 1]) {
                    count = n - (i + 1);
                }

                if (count == A[i])
                    return 1;
            }

        }

        return -1;
    }
}
