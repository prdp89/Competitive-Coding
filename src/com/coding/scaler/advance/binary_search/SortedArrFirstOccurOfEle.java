package com.coding.scaler.advance.binary_search;

public class SortedArrFirstOccurOfEle {

    public static void main(String[] args) {
        System.out.println( solve(new int[] {2,2,5,5,5,8,10,13}, 5));
    }

    private static int solve(int [] A, int target) {
        int n = A.length;
        int l = 0, r = n-1;
        while (l<= r) {
            int mid = l + (r-l) / 2;

            if(A[mid] == target && (mid == 0 || A[mid-1] < target)) {
                return mid;
            }
            if(A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
