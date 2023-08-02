package com.coding.scaler.strings;


public class LongestPalindSubStr {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }

    private static String longestPalindrome(String input) {
        String str = "", ans = "";
        for (int i = 0; i < input.length(); i++) {

            // expanding even length palindromes:
           str = expandPalindromes(input, i, i + 1);

           if(ans.length() < str.length()) {
               ans = str;
           }

            // expanding odd length palindromes:
            str = expandPalindromes(input, i, i);
            if(ans.length() < str.length()) {
                ans = str;
            }
        }

        return ans;
    }

    private static String expandPalindromes(final String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
