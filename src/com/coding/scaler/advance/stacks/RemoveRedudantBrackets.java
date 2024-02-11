package com.coding.scaler.advance.stacks;

import java.util.Stack;

public class RemoveRedudantBrackets {

    /**
     * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
     *
     * Check whether A has redundant braces or not.
     *
     * NOTE: A will be always a valid expression and will not contain any white spaces.
     *
     * Input 1:
     *
     *  A = "((a+b))"
     *
     *  Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     *  ((a+b)) has redundant braces so answer will be 1.
     */
    public static void main(String[] args) {
        System.out.println(braces("((a+b))"));
    }

    private static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (Character ch: A.toCharArray()) {
            if(!stack.empty() && ch == ')') {
                int count  = 0;
                while (stack.peek() != '(') {
                    Character pop = stack.peek();
                    if(pop == '+' || pop == '-' || pop == '/' || pop == '*') {
                        count = 1;
                    }
                    stack.pop();
                }

                //count == 0 means pop has redundant ( bracket.
                if(count == 0)
                    return 1;

                //pop last ( character
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return 0;
    }
}
