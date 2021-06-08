package com.coding.leetcode.contests.weekely.weekely229;

public class MergeAlterStr {

    //https://leetcode.com/contest/weekly-contest-229/problems/merge-strings-alternately/
    public static void main( String[] args ) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    //in one go..
    private static String mergeAlternately( String word1, String word2 ) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++))
                    .append(word2.charAt(j++));
        }

        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }

        if (j < word2.length()) {
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}
