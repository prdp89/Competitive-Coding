package com.coding.leetcode.contests.weekely.weekely237;

public class FindXoRSumAnd {

    //https://leetcode.com/contest/weekly-contest-237/problems/find-xor-sum-of-all-pairs-bitwise-and/
    public static void main( String[] args ) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {6, 5};

        System.out.println(getXORSum(arr1, arr2));
    }

    private static int getXORSum( int[] arr1, int[] arr2 ) {
        int xorA = 0, xorB = 0;
        for (int a : arr1)
            xorA ^= a;

        for (int b : arr2)
            xorB ^= b;

        return xorA & xorB;
    }
}
