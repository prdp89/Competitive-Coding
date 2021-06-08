package com.coding.leetcode.contests.monthlycontest.jancontest;

import java.util.Arrays;

public class CheckArrayFormation {

    //https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/
    //https://leetcode.com/problems/check-array-formation-through-concatenation/
    public static void main( String[] args ) {
        int[] arr = {15, 88};
        int[][] pieces = {
                {88},
                {15}
        };

        System.out.println(canFormArray(arr, pieces));
    }

    //Since both the arrays are distinct and pieces range 1..100 so using count array logic
    private static boolean canFormArray( int[] arr, int[][] pieces ) {
        int[] count = new int[101];
        Arrays.fill(count, -1);

        //mapping index to Pieces[i][0]
        for (int i = 0; i < pieces.length; i++)
            count[pieces[i][0]] = i;

        for (int i = 0; i < arr.length; ) {
            //fetching arr[i] element from count[] array for comparison
            int index = count[arr[i]];
            if (index == -1)
                return false;

            int j = 0;
            //now each arr[i] compare with piece[j]
            while (j < pieces[index].length) {
                if (arr[i++] != pieces[index][j++])
                    return false;
            }
        }

        return true;
    }
}
