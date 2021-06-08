package com.coding.leetcode.contests.weekely.weekely235;

public class TruncateSentence {

    public static void main( String[] args ) {
        String s = "Hello how are you Contestant";
        int k = 4;

        System.out.println(truncateSentence(s, k));
    }

    private static String truncateSentence( String s, int k ) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(strs[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
