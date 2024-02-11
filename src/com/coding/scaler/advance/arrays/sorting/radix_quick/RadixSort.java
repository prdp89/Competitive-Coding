package com.coding.scaler.advance.arrays.sorting.radix_quick;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int [] arr = {236, 18, 52};

        radixSort(arr);
    }

    private static void radixSort(int[] arr) {
        int max = 0;
        for (int item: arr) {
            max = Math.max(max, item);
        }

        for(int exp = 1; exp <= max; exp *= 10){
            countSort(arr,exp);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void countSort(int[] A, int exp) {
        int max = 0;
        for (int num: A) {
            max = Math.max(max, num);
        }

        int [] count = new int[max+1];
        for (int num: A) {
            count[(num/exp)%10]++;
        }

        int [] res = new int[A.length];
        int k = 0;
        for (int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                res[k++] = i;
                count[(i/exp) % 10]--;
            }
        }

        for (int i=0; i<res.length; i++) {
            A[i] = res[i];
        }
    }
}
