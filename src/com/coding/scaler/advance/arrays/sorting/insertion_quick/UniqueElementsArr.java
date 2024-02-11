package com.coding.scaler.advance.arrays.sorting.insertion_quick;

import java.util.Arrays;

public class UniqueElementsArr {

    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 1, 3}));
    }

    /**
     * You are given an array A of N elements. You have to make all elements unique.
     * To do so, in one step you can increase any number by one.
     *
     * Find the minimum number of steps.
     *
     * Input 1:
     *
     *  A = [1, 1, 3]
     *
     *  Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     *  We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
     */

    private static int solve(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        Arrays.sort(A);
        int res = 0, prev = A[0];

        for(int i = 1; i < A.length; i++){
            int expect = prev + 1;
            res += A[i] > expect ? 0 : expect - A[i];
            prev = Math.max(expect, A[i]);
        }
        return res;
    }

}
