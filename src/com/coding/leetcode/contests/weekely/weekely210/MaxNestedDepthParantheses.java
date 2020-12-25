package com.coding.leetcode.contests.weekely.weekely210;

import java.util.Stack;

public class MaxNestedDepthParantheses {

    //https://leetcode.com/contest/weekly-contest-210/problems/maximum-nesting-depth-of-the-parentheses/
    public static void main( String[] args ) {
        String str = "()";
        System.out.println(maxDepth(str));
    }

    private static int maxDepth( String s ) {
        int res = 0;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                res = Math.max(res, stack.size());
                stack.pop();
            }
        }

        return Math.max(res, stack.size());
    }
}
