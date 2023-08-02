package com.coding.scaler.arrays.carry_forward;

public class AmazingSubArrays {

    /**
     * You are given a string S, and you have to find all the amazing substrings of S.
     * <p>
     * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
     * Input
     * ABEC
     * <p>
     * Output
     * 6
     * <p>
     * Explanation
     * Amazing substrings of given string are :
     * 1. A
     * 2. AB
     * 3. ABE
     * 4. ABEC
     * 5. E
     * 6. EC
     * here number of substrings are 6 and 6 % 10003 = 6.
     */
    public static void main(String[] args) {
        System.out.println(solve("anagram"));
    }

    private static int solve(String str) {
        //bcz number of substring/subarray starts from i  = N - i
        int vowels = 0, len = str.length();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowels += len - i;
            }
        }
        return vowels;
    }
}
