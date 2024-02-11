package com.coding.scaler.advance.binary_search;

public class SortInsertPosition {

    /**
     * You are given a sorted array A of size N and a target value B.
     * Your task is to find the index (0-based indexing) of the target value in the array.
     *
     * If the target value is present, return its index.
     * If the target value is not found, return the index of least element greater than equal to B.
     * Your solution should have a time complexity of O(log(N)).
     *
     * A = [1, 4, 9]
     * B = 3
     *
     * Output 2:
     *
     * 1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( searchInsert(new int[] {1,4,9}, 3));
    }

    private static int searchInsert(int[] A, int target) {
        int n = A.length;
        int l = 0, r = n-1;
        while (l<= r) {
            int mid = l + (r-l) / 2;

            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
