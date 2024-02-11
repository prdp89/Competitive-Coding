package com.coding.scaler.advance.arrays.sorting;

import java.util.Arrays;

public class SingleArrayThreeIntegers {

    /**
     * Given an Array with 3 integers L,Y,R where:
     *
     * Sub-array from: l .. y-1 is sorted and y .. r is sorted.
     *
     * Sort and merge the array from L .... R
     *
     * A = {8,1,3,6,11,2,4,9,7,6 }
     * l = 1; y = 5; r = 7
     *
     * sub_arr_1 = {1,3,6,11}  and sub_arr_2 = {2,4,9}
     */
    public static void main(String[] args) {
        int [] arr = {8,1,3,6,11,2,4,9,7,6};
        System.out.println(Arrays.toString(sort(arr, 1, 5,7)));
    }

    private static int [] sort(int [] arr, int l, int y, int r) {
        int [] res = new int[r-l+1];
        int i=l, j=y, k=0;

        while(i < y && j <= r ) {
            if(arr[i] <= arr[j]) {
                res[k] = arr[i];
                k++;
                i++;
            } else {
                res[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i < y) {
            res[k++] = arr[i++];
        }

        while (j <= r) {
            res[k++] = arr[j++];
        }

        return res;
    }
}
