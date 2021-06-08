package com.coding.leetcode.contests.weekely.weekely229;

import java.util.Arrays;

public class MinMoveAllBallsEachBox {

    //https://leetcode.com/contest/weekly-contest-229/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
    public static void main( String[] args ) {
        String b = "001011";
        System.out.println(Arrays.toString(minOperations(b)));
        System.out.println(Arrays.toString(minOperations_Optimal(b)));
    }

    //Runtime: 260 ms
    //Memory Usage: 39.7 MB
    private static int[] minOperations( String boxes ) {
        int[] res = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {

            int count = 0;
            for (int j = 0; j < boxes.length(); j++) {

                if (j != i && boxes.charAt(j) != '0') {
                    count += Math.abs(j - i);
                }
            }
            res[i] = count;
        }

        return res;
    }

    // 2 ms, faster than 100.00% of Java
    private static int[] minOperations_Optimal( String boxes ) {
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];

        int[] res = new int[boxes.length()];

        //if element is 1, then cost to move is 1 else 0;
        int count = boxes.charAt(0) - '0';
        for (int i = 1; i < boxes.length(); i++) { //start from i=1 bcz i=0 left is zero only
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }

        count = boxes.charAt(boxes.length() - 1) - '0';
        for (int i = boxes.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }

        //now sum: left + right
        for (int i = 0; i < boxes.length(); i++)
            res[i] = left[i] + right[i];

        return res;
    }
}