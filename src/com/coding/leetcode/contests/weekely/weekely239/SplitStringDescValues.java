package com.coding.leetcode.contests.weekely.weekely239;

public class SplitStringDescValues {

    public static void main( String[] args ) {
        String s = "050043";
        System.out.println(splitString(s));
    }

    public static boolean splitString( String s ) {
        return isRemainingValid(s, null);
    }

    private static boolean isRemainingValid( String s, Long previous ) {
        long current = 0;

        for (int i = 0; i < s.length(); i++) {
            current = current * 10 + s.charAt(i) - '0';

            if (current >= 10000000000L)
                return false;   // Avoid overflow

            if (previous == null) {
                if (isRemainingValid(s.substring(i + 1), current))
                    return true;
            } else if (current == previous - 1 &&
                    (i == s.length() - 1 || isRemainingValid(s.substring(i + 1), current)))
                return true;
        }

        return false;
    }
}
