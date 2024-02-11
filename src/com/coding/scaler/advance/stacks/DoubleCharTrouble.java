package com.coding.scaler.advance.stacks;

import java.util.Stack;

public class DoubleCharTrouble {

    /**
     * You have a string, denoted as A.
     *
     * To transform the string, you should perform the following operation repeatedly:
     * Identify the first occurrence of consecutive identical pairs of characters within the string.
     * Remove this pair of identical characters from the string.
     * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
     * The final result will be the transformed string.
     *
     * Input 1:
     *
     *  A = "abccbc"
     *
     *  Output 1:
     *
     *  "ac"
     */
    public static void main(String[] args) {
        System.out.println( solve("abccbc"));
    }

    private static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: A.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else if(stack.peek() == ch) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
