package com.coding.scaler.advance.arrays.sorting.insertion_quick;

import java.util.Arrays;

public class RearrangeArrayZeroElementToLeftAndRight {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solve(new int[] {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 4})
        ));
    }

    /**
     * Given Arr[N] elements, rearrange array such that:
     * - A[0] should go to correct position
     * - All elements <= A[0] should move to the leftside of A[0]
     * - All elements > A[0] should move to the rightside of A[0]
     *
     * a = { [10], 3, 8, 15, 6, 12, 2, 18, 7, 15, 4}
     *
     * op = {2, 3, 4, 7, 8, [10], 12, 15, 15, 18 }
     * @param A
     * @return
     */
    private static int[] solve(int [] A) {
        int n = A.length;
        partition(A,0, n);
        return A;
    }

    //this is the inner partition logic of quick sort.
    private static int partition(int[] a, int start, int end) {
        int p1= start + 1, p2 = end-1;

        while (p1 <= p2) {
            if(a[p1] <= a[start])
                p1++;
            else if(a[p2] > a[start]) {
                p2--;
            } else {
                swap(a, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(a, start, p2);

        //this p2 is used a next index in array partition for quick sort algo :)
        return p2;
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[j+1];
        a[i] = temp;
    }
}
