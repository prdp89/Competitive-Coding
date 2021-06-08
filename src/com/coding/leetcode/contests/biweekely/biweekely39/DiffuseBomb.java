package com.coding.leetcode.contests.biweekely.biweekely39;

public class DiffuseBomb {

    //https://leetcode.com/contest/biweekly-contest-39/problems/defuse-the-bomb/
    public static void main( String[] args ) {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        for (int i : decrypt(code, k)) {
            System.out.print(i + " ");
        }
    }

    private static int[] decrypt( int[] code, int k ) {
        int[] res = new int[code.length];
        if (k == 0)
            return res;

        //declaring initial window when K is +ve
        int start = 1, end = k, sum = 0;
        if (k < 0) { //if k < 0 then starting/end point will at end of array
            start = code.length - k;
            end = code.length - 1;
        }

        //calculating first window sum
        for (int i = start; i <= end; i++)
            sum += code[i];

        //sliding window and calculating sum for rest of items
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;

            sum -= code[start++ % code.length];
            sum += code[++end % code.length];
        }

        return res;
    }
}
