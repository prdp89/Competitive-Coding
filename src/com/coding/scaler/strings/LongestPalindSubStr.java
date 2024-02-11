package com.coding.scaler.strings;


public class LongestPalindSubStr {

    /**
     * Given a string A of size N, find and return the longest palindromic substring in A.
     *
     * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
     *
     * Palindrome string:
     * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
     *
     * Incase of conflict, return the substring which occurs first ( with the least starting index).
     *
     * Input 1:
     * A = "aaaabaaa"
     *
     * Output 1:
     * "aaabaaa"
     *
     * Explanation 1:
     * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(longestPalindrome("aaaabaaa"));

        System.out.println(longestPalindrome("banana"));
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
