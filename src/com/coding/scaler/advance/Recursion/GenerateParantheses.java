package com.coding.scaler.advance.Recursion;

import java.util.ArrayList;

public class GenerateParantheses {

    /**
     * Given an integer A pairs of parentheses, write a function to generate all
     * combinations of well-formed parentheses of length 2*A.
     *
     * Input 1:
     *
     * A = 3
     *
     * Output 1:
     *
     * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     * @param args
     */
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    private static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        generateParam(A, A, "", result);
        return result;
    }

    private static void generateParam(int left, int right, String curr, ArrayList<String> res) {
        if(left == 0 && right == 0) {
            res.add(curr);
            return;
        }

        if(left > 0) {
            generateParam(left-1, right, curr + "(", res);
        }

        if(left < right) {
            generateParam(left, right-1, curr + ")", res);
        }
    }
}
