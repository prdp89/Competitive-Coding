package com.coding.leetcode.contests.weekely.weekely238;

public class LongestSubStringVowels {

    //https://leetcode.com/contest/weekly-contest-238/problems/longest-substring-of-all-vowels-in-order/
    public static void main( String[] args ) {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(word));
    }

    private static int longestBeautifulSubstring( String word ) {
        int vowelsCount = 0, currLen = 0, res = 0;
        for (int i = 0; i < word.length(); i++) {

            //if next char is smaller than prev; reset the counters
            if (i != 0 && word.charAt(i) < word.charAt(i - 1)) {
                vowelsCount = currLen = 0;
            }

            //bcz every character is vowel..
            currLen++;
            if (i == 0 || word.charAt(i) != word.charAt(i - 1))
                vowelsCount++;

            if (vowelsCount == 5)
                res = Math.max(res, currLen);
        }

        return res;
    }
}