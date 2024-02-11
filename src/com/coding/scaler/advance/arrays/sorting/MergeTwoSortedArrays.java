package com.coding.scaler.advance.arrays.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {4,7,9}, new int[] {2,11,19})));
    }

    private static int[] solve(final int[] A, final int[] B) {
        int m = A.length, n = B.length;
        int [] c = new int[m+n];

        int i=0, j=0, k=0;
        while(i < m && j < n) {
            if(A[i] <= B[j]) {
                c[k] = A[i];
                k++;
                i++;
            } else {
                c[k] = B[j];
                k++;
                j++;
            }
        }

        while(i<m) {
            c[k] = A[i];
            k++;
            i++;
        }

        while(j<n) {
            c[k] = B[j];
            k++;
            j++;
        }

        return c;
    }
}
