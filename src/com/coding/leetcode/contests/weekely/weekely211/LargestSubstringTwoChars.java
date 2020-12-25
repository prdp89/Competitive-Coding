package com.coding.leetcode.contests.weekely.weekely211;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubstringTwoChars {

    //https://leetcode.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/
    public static void main( String[] args ) {
        String s = "ojdncpvyneq";
        System.out.println(maxLengthBetweenEqualCharacters(s));

        System.out.println(maxLengthBetweenEqualCharacters_twoPass(s));


        System.out.println(maxLengthBetweenEqualCharacters_onePass(s));
    }

    /*
    Runtime: 5 ms
    Memory Usage: 37 MB
     */
    private static int maxLengthBetweenEqualCharacters( String s ) {
        int len = -1;

        /*while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                len = Math.max(len, j - i - 1);
            }

            i++;
            j--;
        }*/

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    len = Math.max(len, j - i - 1);
            }
        }

        return len;
    }

    private static int maxLengthBetweenEqualCharacters_twoPass( String s ) {
        int[] in = new int[26];
        Arrays.fill(in, -1);

        //storing last occurrence of each char
        for (int i = 0; i < s.length(); i++) {
            in[s.charAt(i) - 'a'] = i;
        }

        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            if (in[ch] != -1 && in[ch] != i) {
                max = Math.max(max, in[ch] - i - 1);
            }
        }

        return max;
    }

    private static int maxLengthBetweenEqualCharacters_onePass( String s ) {
        Map<Character, Integer> map = new HashMap();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                max = Math.max(max, i - map.get(c) - 1);
            } else {
                map.put(c, i);
            }
        }

        return max;
    }
}
