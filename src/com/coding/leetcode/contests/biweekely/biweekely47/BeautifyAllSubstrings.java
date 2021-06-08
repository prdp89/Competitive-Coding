package com.coding.leetcode.contests.biweekely.biweekely47;

public class BeautifyAllSubstrings {

    //https://leetcode.com/contest/biweekly-contest-47/problems/sum-of-beauty-of-all-substrings/
    public static void main( String[] args ) {
        System.out.println(beautySum_solve("aabcb"));
    }

    private static int beautySum_try( String s ) {
        int[] count = new int[26];
        for (Character ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                min = Math.min(min, count[i]);
            }

            max = Math.max(max, count[i]);
        }


        return 0;
    }

    private static int beautySum_solve( String s ) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            //for each substring calc max - min that's it..

            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                sum += findDiff(count);
            }
        }

        return sum;
    }

    private static int findDiff( int[] count ) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                min = Math.min(min, count[i]);
                max = Math.max(max, count[i]);
            }
        }

        return max - min;
    }
}
