package com.coding.scaler.advance.arrays.sorting;

import java.util.Arrays;

public class WaveArray {

    /**
     * Given an array of integers A, sort the array into a wave-like array and return it.
     * In other words, arrange the elements into a sequence such that
     *
     * a1 >= a2 <= a3 >= a4 <= a5.....
     * NOTE: If multiple answers are possible, return the lexicographically smallest one.
     *
     * Input 1:
     *
     * A = [1, 2, 3, 4]
     *
     * Output 1:
     *
     * [2, 1, 4, 3]
     *
     *
     * Explanation 1:
     *
     * One possible answer : [2, 1, 4, 3]
     * Another possible answer : [4, 1, 3, 2]
     * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( Arrays.toString(wave(new int[] {1, 2, 3, 4})));
    }

    private static int[] wave(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i+=2) {
            swap(nums, i, i-1);
        }
        return nums;
    }

    private static void swap(int arr[],int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
