package com.coding.scaler.arrays.sorting;

import java.util.Arrays;

public class LargestNumber {

    /**
     * Given an array A of non-negative integers, arrange them such that they form the largest number.
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {3, 30, 34, 5, 9}));
    }


    private static String largestNumber(final int[] A) {
        Integer[] arr = new Integer[A.length];
        for (int i=0; i<A.length; i++)
            arr[i] = A[i];

        Arrays.sort(arr, (x, y) -> {
            String str1 = String.valueOf(x) + String.valueOf(y), str2 = String.valueOf(y) + String.valueOf(x);
            return str2.compareTo(str1);
        });

        if(arr[0] == 0)
            return "0";

        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            str.append(arr[i]);
        }
        return str.toString();
    }
}
