package com.coding.scaler.advance.binary_search;

public class SearchForRange {

    public static void main(String[] args) {
        int [] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int first = searchRange(A, B);
        int last = searchRangeLast(A, B);

        System.out.println("First : " + first + " Second : " + last);
    }

    private static int searchRange(final int[] A, int target) {

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

    private static int searchRangeLast(final int[] A, int target) {

        int n = A.length;
        int l = 0, r = n-1, index = -1;
        while (l <= r) {
            int mid = l + (r-l) / 2;

            if(A[mid] == target ) {
                index = mid;

                //drag left to mid+1
                l = mid + 1;
            }
            //use else
            else if(A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return index;
    }
}
