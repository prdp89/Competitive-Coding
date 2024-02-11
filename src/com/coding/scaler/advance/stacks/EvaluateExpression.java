package com.coding.scaler.advance.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

    /**
     * An arithmetic expression is given by a string array A of size N.
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, /. Each string may be an integer or an operator.
     *
     * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
     *
     * Input 1:
     * A =   ["2", "1", "+", "3", "*"]
     *
     * Output 1:
     * 9
     */
    public static void main(String[] args) {

    }

    private static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(String str : A) {
            if(!stack.isEmpty() && str.equals("/") || str.equals("*") || str.equals("+") || str.equals("-")) {
                int str1 = stack.pop();
                int str2 = stack.pop();

                int res = 0;
                if(str.equals("+"))
                    res = str1 + str2;
                else if(str.equals("-"))
                    res = str2 - str1;
                else if(str.equals("/"))
                    res = str2 / str1;
                else if(str.equals("*"))
                    res = str2 * str1;

                stack.push(res);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }
}
