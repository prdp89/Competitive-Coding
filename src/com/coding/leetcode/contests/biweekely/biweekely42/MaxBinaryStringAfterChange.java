package com.coding.leetcode.contests.biweekely.biweekely42;

public class MaxBinaryStringAfterChange {

    //https://leetcode.com/problems/maximum-binary-string-after-change/
    public static void main( String[] args ) {
        String binary = "000110";
        System.out.println(maximumBinaryString(binary));
    }

    private static String maximumBinaryString( String binary ) {
        int i, starting_ones = 0, zeros = 0, ones = 0, n = binary.length();
        StringBuilder ans = new StringBuilder();

        for (i = 0; i < n; i++) {

            if (binary.charAt(i) == '1')
                starting_ones++;
            else
                break;
        }

        for (i = starting_ones; i < n; i++) {
            if (binary.charAt(i) == '0')
                zeros++;
            else
                ones++;
        }

        for (i = 0; i < starting_ones; i++)
            ans.append('1');

        //confused little in this part..
        for (i = 1; i < zeros; i++)
            ans.append('1');

        if (zeros > 0) // in-case there are no zero's
            ans.append('0');

        for (i = 0; i < ones; i++)
            ans.append('1');

        return ans.toString();
    }
}
