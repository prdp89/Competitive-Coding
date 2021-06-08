package com.coding.leetcode.contests.monthlycontest.marcontest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingWords {

    //https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/
    public static void main( String[] args ) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    private static int minimumLengthEncoding( String[] words ) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) { //if start with 1 then it will remove every string from Set
                set.remove(word.substring(i));
            }
        }

        int res = 0;
        for (String str : set) {
            res += str.length() + 1;
        }

        return res;
    }
}
