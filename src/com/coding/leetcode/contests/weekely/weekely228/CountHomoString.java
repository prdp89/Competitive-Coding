package com.coding.leetcode.contests.weekely.weekely228;

import java.util.HashMap;

public class CountHomoString {

    //https://leetcode.com/contest/weekly-contest-228/problems/count-number-of-homogenous-substrings/
    public static void main( String[] args ) {
        String s = "abbcccaa";
        System.out.println(countHomogenous(s));
        System.out.println(countHomogenousOptimal(s));
    }

    //not able to solve :(
    private static int countHomogenous( String s ) {

        HashMap<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        map.put(s.charAt(0) + "", 1);

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                sb.append(s.charAt(i));

                map.put(sb.toString(), map.getOrDefault(sb.toString(), 1) + 1);
            } else {
                sb = new StringBuilder();

                map.put(s.charAt(i - 1) + "", map.getOrDefault(s.charAt(i - 1) + "", 1) + 1);
                map.put(s.charAt(i) + "", map.getOrDefault(s.charAt(i) + "", 1) + 1);
                //map.put(s.charAt(i) + "", 1);

                sb.append(s.charAt(i));
            }
        }

        int res = 0;
        for (String str : map.keySet()) {
            res += map.get(str);
        }

        return res;
    }

    private static int countHomogenousOptimal( String s ) {
        int res = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                count = 1;
            }

            res = (res + count) % 1000000007;
        }

        return res;
    }
}