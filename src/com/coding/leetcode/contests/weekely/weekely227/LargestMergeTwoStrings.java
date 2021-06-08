package com.coding.leetcode.contests.weekely.weekely227;

public class LargestMergeTwoStrings {

    //https://leetcode.com/contest/weekly-contest-227/problems/largest-merge-of-two-strings/
    public static void main( String[] args ) {
        String word1 = "cabaa", word2 = "bcaaa";
        System.out.println(largestMerge(word1, word2));
    }

    private static String largestMerge( String word1, String word2 ) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else if (word2.charAt(j) > word1.charAt(i)) {
                sb.append(word2.charAt(j++));
            } else { //if both character are equal then check remaining string from i or j
                //if remaining first string > second string
                if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                    sb.append(word1.charAt(i++));
                } else
                    sb.append(word2.charAt(j++));
            }
        }

        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
