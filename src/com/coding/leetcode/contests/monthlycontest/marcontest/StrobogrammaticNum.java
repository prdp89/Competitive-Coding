package com.coding.leetcode.contests.monthlycontest.marcontest;

import java.util.HashMap;

public class StrobogrammaticNum {

    //https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/246.html
    public static void main( String[] args ) {
        System.out.println(isStrobogrammatic("818"));
    }

    /*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    For example, the numbers "69", "88", and "818" are all strobogrammatic.
     */

    private static boolean isStrobogrammatic( String num ) {
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('8', '8');
        dict.put('6', '9');
        dict.put('9', '6');

        int i = 0;
        int j = num.length() - 1;

        while (i <= j) {
            char f = num.charAt(i);
            char b = num.charAt(j);

            if (dict.containsKey(f) && dict.containsKey(b) && dict.get(f) == b) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
