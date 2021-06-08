package com.coding.leetcode.contests.biweekely.biweekely43;

import java.util.Stack;

public class MaxScoreRemovingStrings {

    //https://leetcode.com/contest/biweekly-contest-43/problems/maximum-score-from-removing-substrings/
    public static void main( String[] args ) {
        String str = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(maximumGain(str, x, y));
    }

    //Runtime: 91 ms, faster than 60.24%
    //O(N) time and Space

    //https://leetcode.com/problems/maximum-score-from-removing-substrings/discuss/1008862/Java-Stack
    private static int maximumGain( String s, int x, int y ) {
        Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();

        int result = 0, max = Math.max(x, y), min = Math.min(x, y);

        char first = (x > y) ? 'a' : 'b', second = (x > y) ? 'b' : 'a';

        for (char c : s.toCharArray())
            //removing the char based on Max points
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                result += max;
            } else stack.push(c);

        while (!stack.isEmpty()) {
            char c = stack.pop();

            //removing the char based on Min points
            if (!stack2.isEmpty() && stack2.peek() == first && c == second) {
                stack2.pop();
                result += min;
            } else stack2.push(c);
        }

        return result;
    }
}
