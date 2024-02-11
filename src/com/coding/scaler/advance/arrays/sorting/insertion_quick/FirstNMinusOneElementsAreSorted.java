package com.coding.scaler.advance.arrays.sorting.insertion_quick;

import java.util.Arrays;

public class FirstNMinusOneElementsAreSorted {

    /**
     * Given A[], First N-1 elements are sorted, sort the entire Array.
     *
     * A = { 2, 6, 20, 14, 20, 4}
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] { 2, 6, 20, 14, 20, 4})));

        //insertion sort
        System.out.println(Arrays.toString(insertion_sort(new int[] { 2, 6, 20, 14, 20, 4})));
    }

    private static int[] solve(int [] A) {
        int n = A.length;

        //this is inner loop of Insertion sort.
        for (int j=n-2; j>= 0; j--) {
            if(A[j] > A[j+1])
                swap(A, j, j+1);
        }
        return A;
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[j+1];
        a[i] = temp;
    }

    private static int[] insertion_sort(int [] A) {
        int n = A.length;

        for (int i=1; i<n; i++) {

            for (int j = i-1; j >=0 ; j--) {

                if(A[j] > A[j+1])
                swap(A, j, j+1);
            }
        }

        return A;

    }
}
