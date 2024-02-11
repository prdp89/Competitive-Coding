package com.coding.scaler.advance.binary_search;

public class SearchSortedRotatedArr {

    public static void main(String[] args) {
        System.out.println(search(new int[] {9, 10, 3, 5, 6, 8}, 5));
    }

    /**
     * Given a sorted array of integers A of size N and an integer B,
     * where array A is rotated at some pivot unknown beforehand.
     *
     * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
     *
     * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
     *
     * You can assume that no duplicates exist in the array.
     *
     * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
     *
     * A : [ 9, 10, 3, 5, 6, 8 ]
     * B : 5
     *
     * Output:
     *
     *  3
     */
    private static int search(final int[] A, int B) {
        return searchInSortedAndRotatedArray(A, B, 0, A.length-1);
    }

    private static int searchInSortedAndRotatedArray( int[] a, int keyToSearch, int start, int end ) {

        //Base case
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        //if key found
        if (a[mid] == keyToSearch)
            return mid;

        //If Mid lies in first line of Rotated array graph or we can say :
        //If a[start...mid] is sorted
        if (a[start] <= a[mid]) {

            //If Mid lies in Left side of Array
            if (keyToSearch >= a[start] && keyToSearch <= a[mid])
                return searchInSortedAndRotatedArray(a, keyToSearch, start, mid - 1);
            else //or right side of array
                return searchInSortedAndRotatedArray(a, keyToSearch, mid + 1, end);
        }

        //else if Mid lies in second line of Rotated array graph
        if (keyToSearch >= a[mid] && keyToSearch <= a[end])
            return searchInSortedAndRotatedArray(a, keyToSearch, mid + 1, end); //search in right part of array

        //otherwise search in left part of the array
        return searchInSortedAndRotatedArray(a, keyToSearch, start, mid - 1);
    }
}
