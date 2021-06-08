package com.coding.leetcode.contests.biweekely.biweekely40;

public class MaxRepeatingSubStr {

    //https://leetcode.com/contest/biweekly-contest-40/problems/maximum-repeating-substring/
    public static void main( String[] args ) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        System.out.println(maxRepeating(sequence, word));

        System.out.println(maxRepeating_Optimized(sequence, word));
    }

    //aaaba aaaba aab a aaaba aaaba aaaba aaaba
    //168 / 211 test cases passed.
    private static int maxRepeating( String sequence, String word ) {
        if (!sequence.contains(word)) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < sequence.length(); i++) {

            if (sequence.charAt(i) == word.charAt(0)) {
                int count = 0;

                for (int j = 0; j < word.length() && i < sequence.length(); j++) {
                    if (word.charAt(j) != sequence.charAt(i)) {
                        break;
                    }

                    count++;
                    i++;
                }

                if (count == word.length()) {
                    res++;
                }
                i--;
            }
        }

        return res;
    }

    //Runtime: 1 ms
    private static int maxRepeating_Optimized( String sequence, String word ) {
        int ans = 1;
        String temp = word;

        while (sequence.contains(word)) {
            ++ans;
            word += temp;
        }
        return ans - 1;
    }
}
