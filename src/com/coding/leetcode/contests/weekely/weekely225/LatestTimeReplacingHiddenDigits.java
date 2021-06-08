package com.coding.leetcode.contests.weekely.weekely225;

public class LatestTimeReplacingHiddenDigits {

    //https://leetcode.com/contest/weekly-contest-225/problems/latest-time-by-replacing-hidden-digits/
    public static void main( String[] args ) {
        String time = "?4:03";
        System.out.println(maximumTime(time));
    }

    private static String maximumTime( String time ) {
        StringBuilder sb = new StringBuilder();

        if (time.charAt(0) == '?') {
            if (time.charAt(1) != '?' && Character.getNumericValue(time.charAt(1)) > 3)
                sb.append('1');
            else
                sb.append('2');
        } else
            sb.append(time.charAt(0));

        if (time.charAt(1) == '?') {
            int t = Character.getNumericValue(sb.charAt(0));
            if (t < 2)
                sb.append('9');
            else
                sb.append("3");
        } else
            sb.append(time.charAt(1));

        sb.append(time.charAt(2));

        if (time.charAt(3) == '?') {
            sb.append("5");
        } else
            sb.append(time.charAt(3));

        if (time.charAt(4) == '?') {
            sb.append("9");
        } else
            sb.append(time.charAt(4));

        return sb.toString();
    }
}
