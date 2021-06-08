package com.coding.leetcode.contests.weekely.weekely234;

import java.util.HashSet;
import java.util.Set;

public class DiffIntegerstr {

    //https://leetcode.com/contest/weekly-contest-234/problems/number-of-different-integers-in-a-string/
    //https://leetcode.com/problems/number-of-different-integers-in-a-string/
    public static void main( String[] args ) {
        String str = "0i00e";
        System.out.println(numDifferentIntegers(str));
    }

    //80 / 81 test cases passed.
    private static int numDifferentIntegers( String word ) {
        HashSet<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                sb.append(word.charAt(i));

                int j = i + 1;
                for (; j < word.length() && Character.isDigit(word.charAt(j)); j++) {
                    sb.append(word.charAt(j));
                }

                i = j;
                if (sb.length() > 1) {
                    int k = 0;
                    for (; k < sb.length() && sb.charAt(k) == '0'; k++) {
                    }

                    if (!sb.substring(k).isEmpty())
                        set.add(sb.substring(k));
                } else if (sb.length() == 1) {
                    set.add(sb.toString());
                }

                sb = new StringBuilder();
            }
        }

        return set.size();
    }

    //using regex
    //Runtime: 13 ms
    //Memory Usage: 39 MB
    private static int numDifferentIntegers_regex( String word ) {
        String[] arr = word.split("\\D");
        Set<String> s = new HashSet<>();

        for (String str : arr) {
            str = str.trim();
            if (!str.isEmpty()) {
                str = str.replaceAll("^0*", "");
                s.add(str);
            }
        }

        return s.size();
    }
}
