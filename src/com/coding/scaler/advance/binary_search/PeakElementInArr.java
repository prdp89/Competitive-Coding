package com.coding.scaler.advance.binary_search;

public class PeakElementInArr {

    /**
     * Given an array of integers A, find and return the peak element in it.
     * An array element is considered a peak if it is not smaller than its neighbors.
     * For corner elements, we need to consider only one neighbor.
     *
     * NOTE:
     *
     * It is guaranteed that the array contains only a single peak element.
     * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {5, 17, 100, 11}));
    }

    private static int solve(int[] A) {
        int n = A.length;
        if(n == 1)
            return A[0];

        if(A[0] >= A[1])
            return A[0];
        else if(A[n-1] >= A[n-2]){
            return A[n-1];
        }

        int l =0, r = n-1;

        while(l <= r) {
            int mid = l+(r-l)/2;

            if((mid == 0 || A[mid-1] < A[mid]) && (
                    mid == n-1 || A[mid+1] < A[mid]
            )) {
                return A[mid];
            }

            //checking m-1 bcz we want to be in exact MID to find Peak index.
            if(mid > 0 && A[mid-1] > A[mid]) {
                r = mid-1;
            } else
                l = mid+1;
        }

        return -1;
    }
}
