package com.coding.leetcode.contests.biweekely.biweekely44;

import java.util.Arrays;

public class DecodeXoRPermutation {

    //https://leetcode.com/contest/biweekly-contest-44/problems/decode-xored-permutation/
    //https://leetcode.com/problems/decode-xored-permutation/
    public static void main( String[] args ) {
        int[] encoded = {3, 1};
        System.out.println(Arrays.toString(decode(encoded)));
    }

    //Runtime: 2 ms, faster than 100.00% of Java
    //https://www.youtube.com/watch?t=0&v=I5-uDlbwbOA&feature=youtu.be
    //We are given encoded array and need to find array of encode.length + 1
    //Step 1: bcz array result permutation can be 1..N so we can do XOR(1, 2 ..N)
    //Step 2: Then we do XOR of ODD elements
    private static int[] decode( int[] encoded ) {
        int totalXoR = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            totalXoR ^= i;
        }

        //Step2:
        int oddElemXoR = 0;
        for (int i = 1; i < encoded.length; i += 2)
            oddElemXoR ^= encoded[i];

        int firstElement = totalXoR ^ oddElemXoR;
        int[] res = new int[encoded.length + 1];
        res[0] = firstElement;

        //now similar to:https://leetcode.com/problems/decode-xored-array/
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }

        return res;
    }
}
