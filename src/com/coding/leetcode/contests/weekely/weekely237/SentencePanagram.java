package com.coding.leetcode.contests.weekely.weekely237;

public class SentencePanagram {

    //https://leetcode.com/contest/weekly-contest-237/problems/check-if-the-sentence-is-pangram/
    public static void main( String[] args ) {
        String sentence = "leetcode";
        System.out.println(checkIfPanagram(sentence));
    }

    private static boolean checkIfPanagram( String sentence ) {
        int[] arr = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0)
                return false;
        }

        return true;
    }
}
