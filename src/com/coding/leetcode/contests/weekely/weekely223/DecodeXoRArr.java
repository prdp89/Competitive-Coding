package com.coding.leetcode.contests.weekely.weekely223;

import java.util.Arrays;

public class DecodeXoRArr {

    //https://leetcode.com/contest/weekly-contest-223/problems/decode-xored-array/
    public static void main( String[] args ) {
        int[] encoded = {6, 2, 7, 3};
        int first = 4;

        System.out.println(Arrays.toString(decode(encoded, first)));
    }

    //Runtime: 1 ms
    //Memory Usage: 40 MB
    private static int[] decode( int[] encoded, int first ) {
        int[] res = new int[encoded.length + 1];

        res[0] = first;

        for (int i = 1; i < res.length; i++) {
            res[i] = (encoded[i - 1] ^ res[i - 1]);
        }

        return res;
    }
}
