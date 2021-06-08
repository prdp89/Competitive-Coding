package com.coding.leetcode.contests.biweekely.biweekely45;

import java.util.Arrays;

public class SumOfUniqueElem {

    //https://leetcode.com/contest/biweekly-contest-45/problems/sum-of-unique-elements/
    public static void main( String[] args ) {
        int[] arr = {1,2,3,4,5};
        System.out.println(sumOfUnique(arr));
    }

    private static int sumOfUnique( int[] nums ) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);

        for (int num : nums) {
            arr[num]++;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
