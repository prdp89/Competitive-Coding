package com.coding.leetcode.contests.monthlycontest.febcontest;

public class NumberOf1Bits {

    //https://leetcode.com/problems/number-of-1-bits/
    public static void main( String[] args ) {
        System.out.println(hammingWeight(3));
    }

    //Runtime: 1 ms, faster than 29.65% of Java
    public static int hammingWeight( int n ) {
        int ones = 0;

        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;

            //This result in TLE
            //n = n >> 1;
        }

        return ones;
    }
}
