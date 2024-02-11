package com.coding.scaler.advance.arrays.sorting;

public class ReversePair {

    //also in leetcode: https://leetcode.com/problems/reverse-pairs/description/
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1, 3, 2, 3, 1}));
    }

    /**
     * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
     * Return the number of important reverse pairs in the given array A.
     *
     * Input 1:
     *
     *  A = [1, 3, 2, 3, 1]
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  There are two pairs which are important reverse pair
     *  i.e  (1, 4) => A[1] > 2 * A[4] => 3 > 2 * 1 => 3 > 2 and
     *       (3, 4) => A[3] > 2 * A[4] => 3 > 2 * 1 => 3 > 2.
     * @param A
     * @return
     */
    private static int solve(int[] A) {
        int [] temp = new int[A.length];
        long res = _mergeSort(A, temp, 0, A.length-1);
        return (int) res;
    }

    private static long _mergeSort( int arr[], int temp[], int left, int right ) {
        int mid, count = 0;
        long inv_count = 0;

        if (right > left) {
            /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left) / 2;

            /* Inversion count will be sum of inversions in left-part, right-part
                and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            // do reverse check before merging two already sorted halves
            int i = left; // left part head ptr
            int j = mid+1; // right part head ptr
            while(i <= mid && j <= right){
                if(arr[i]/2.0 > arr[j]){ //can also do: arr[i] > 2.0 * arr[j] but this creates overflow may be :)
                    count += (mid - i + 1); // remaining elems of left part
                    j++;
                }else{
                    i++;
                }
            }

            // then merge
            /*Merge the two parts*/
            merge(arr, temp, left, mid + 1, right);
        }
        return inv_count + count;
    }

    private static long merge( int arr[], int temp[], int left, int mid, int right ) {
        int i, j, k;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

        /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return 0;
    }
}
