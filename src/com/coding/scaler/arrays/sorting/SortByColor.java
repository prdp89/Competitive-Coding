package com.coding.scaler.arrays.sorting;

import java.util.Arrays;

public class SortByColor {

    /**
     * Given an array with N objects colored red, white, or blue,
     * sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{0, 1, 2, 0, 1, 2})));
    }

    private static int[] sortColors(int[] nums) {
        int pivot0 = 0;
        int pivot2 = nums.length - 1;

        for (int i = 0; i <= pivot2; ) {
            if (nums[i] == 2) { //swap 2 to the end, and then pivot2--
                int temp = nums[pivot2];
                nums[pivot2] = 2;
                nums[i] = temp;
                pivot2--;
            } //0 from the end may swap to nums[i], therefore we should check 2 first then 0
            if (nums[i] == 0) { //swap 0 to the head, and then pivot0++
                int temp = nums[pivot0];
                nums[pivot0] = 0;
                nums[i] = temp;
                pivot0++;
                i++;
            } else if (nums[i] == 1) i++;
        }

        return nums;
    }
}
