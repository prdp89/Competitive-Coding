package com.coding.scaler.advance.arrays.sorting.radix_quick;

import java.util.Arrays;

public class MaxUnsortedSubArr {

    /**
     * Given an array A of non-negative integers of size N.
     * Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
     *
     * Note :
     * Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
     *
     * Output Format
     * Return an array of length two where,
     * the first element denotes the starting index(0-based) and
     * the second element denotes the ending index(0-based) of the sub-array.
     * If the array is already sorted, return an array containing only one element i.e. -1.
     *
     *
     * Input 1:
     *
     * A = [1, 3, 2, 4, 5]
     *
     * Output 1:
     *
     * [1, 2]
     *
     * Explanation 1:
     *
     * If we sort the sub-array [A1, A2] then the whole array A gets sorted.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subUnsort(new int[] {1, 3, 2, 4, 5})));
    }

    private static int[] subUnsort(int[] A) {
        int start = -1;
        for(int i=0; i<A.length-1; i++) {
            if(A[i] > A[i+1]) {
                start = i;
                break;
            }
        }

        if(start == -1)
        {
            return new int [] {-1};
        }

        int end = -1;
        for(int i=A.length-1; i > 0; i--) {
            if(A[i] < A[i-1]) {
                end = i;
                break;
            }
        }

        // Find the minimum and maximum element in the subarray A[start_pos...end_pos]
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int left = 0;
        while(left < start && A[left] <= min )
            left++;

        int right = A.length-1;
        while(right > end && A[right] >= max )
            right--;

        return new int []{
                left,
                right
        };
    }
}
