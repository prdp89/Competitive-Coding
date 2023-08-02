package com.coding.scaler.strings;

public class LongestCommonPrefix {

    /**
     * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
     *
     * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
     *
     * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
     *
     */
    public static void main(String[] args) {
        System.out.println( longestCommonPrefix(new String[]{"abab", "ab" , "abcd"}));
    }

    private static String longestCommonPrefix(String[] A) {
        String res = A[0];

        for(int i=1; i< A.length; i++) {
            res = findPrefix(res, A[i]);
        }

        return res;
    }

    private static String findPrefix(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n && s1.charAt(i) == s2.charAt(i); i++){
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
}
