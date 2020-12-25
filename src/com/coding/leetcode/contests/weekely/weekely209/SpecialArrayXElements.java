package com.coding.leetcode.contests.weekely.weekely209;

public class SpecialArrayXElements {

    //https://leetcode.com/contest/weekly-contest-209/problems/special-array-with-x-elements-greater-than-or-equal-x/
    public static void main( String[] args ) {
        int[] nums = {3, 5};
        System.out.println(specialArray(nums));
    }

    private static int specialArray( int[] nums ) {
        int[] arr = new int[102];
        for (int item : nums)
            ++arr[item > 100 ? 100 : item];

        for (int i = 100; i > 0; i--) {
            arr[i] = arr[i] + arr[i + 1];

            if (arr[i] == i)
                return i;
        }

        return -1;
    }
}
