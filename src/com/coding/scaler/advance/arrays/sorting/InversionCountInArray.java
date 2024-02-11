package com.coding.scaler.advance.arrays.sorting;

public class InversionCountInArray {

    /**
     * Given an array of integers A. If i < j and A[i] > A[j],
     * then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
     *
     * A = [3, 4, 1, 2]
     *
     * Output 2:
     *
     * 4
     *
     * Explanation 2:
     *
     * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
     * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
     * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
     * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {3, 4, 1, 2}));
    }

    private static int solve(int[] A) {
        int [] temp = new int[A.length];
        long res = _mergeSort(A, temp, 0, A.length-1);
        return (int) (res % (int) (1e9 + 7));
    }

    private static long _mergeSort( int arr[], int temp[], int left, int right ) {
        int mid;
        long inv_count = 0;

        if (right > left) {
            /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left) / 2;

            /* Inversion count will be sum of inversions in left-part, right-part
                and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    private static long merge( int arr[], int temp[], int left, int mid, int right ) {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] > 2* arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                //This is explained in CodingBlocks as:
                //left[] = {1,2,6} right = {1,1,6}
                //NOw in merging we compare '2' from left with '1' in right
                //'2' in left is greater which means inversion so total inversions will be Sum of element after '2' in left array
                //It is calculated using : mid - i
                inv_count = inv_count + mid - i;
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

        return inv_count;
    }
}
