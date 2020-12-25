package com.coding.leetcode.contests.monthlycontest.octcontest;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    //https://leetcode.com/problems/buddy-strings/
    public static void main( String[] args ) {
        String A = "ab";
        String B = "ba";

        System.out.println(buddyStrings(A, B));
    }

    private static boolean buddyStrings( String A, String B ) {
        if (A.length() != B.length())
            return false;

        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();

            //if both Strings are equal and A has duplicate chars means B will also have duplicate chars;
            //so we can make buddy strings
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i)))
                    return true;

                set.add(A.charAt(i));
            }

            //otherwise, set contains all unique chars that cannot form buddy strings.
            return false;
        }

        int twoCharCounter = 0, aValue = 0, bValue = 0;
        for (int i=0; i<A.length(); i++) {
            aValue += A.charAt(i);
            bValue += B.charAt(i);

            if(A.charAt(i) != B.charAt(i))
                twoCharCounter++;

            if(twoCharCounter > 2)
                return false;
        }

        //otherwise diff. is 2, we can swap two chars if sum is same;
        return aValue == bValue;
    }
}
