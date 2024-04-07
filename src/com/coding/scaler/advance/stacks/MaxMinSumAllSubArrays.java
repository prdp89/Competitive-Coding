package com.coding.scaler.advance.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaxMinSumAllSubArrays {

    /**
     * Given an array of integers A.
     *
     * The value of an array is computed as the difference between the maximum element
     * in the array and the minimum element in the array A.
     *
     * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
     *
     * Input 2:
     *  A = [4, 7, 3, 8]
     *
     *  Output 2:
     *  26
     *
     *  Explanation 2:
     * value ( [4] ) = 4 - 4 = 0
     * value ( [7] ) = 7 - 7 = 0
     * value ( [3] ) = 3 - 3 = 0
     * value ( [8] ) = 8 - 8 = 0
     * value ( [4, 7] ) = 7 - 4 = 3
     * value ( [7, 3] ) = 7 - 3 = 4
     * value ( [3, 8] ) = 8 - 3 = 5
     * value ( [4, 7, 3] ) = 7 - 3 = 4
     * value ( [7, 3, 8] ) = 8 - 3 = 5
     * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
     * sum of values % 10^9+7 = 26
     */
    public static void main(String[] args) {
        System.out.println(
                solve(
                        new ArrayList<>(Arrays.asList(4, 7, 3, 8))
                ));
    }

    private static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> nsl = generateLeft(A, "min");
        ArrayList<Integer> nsr = generateRight(A, "min");
        ArrayList<Integer> ngl = generateLeft(A, "max");
        ArrayList<Integer> ngr = generateRight(A, "max");
        long mod = 1000000007;

        long sum = 0;
        for(int i = 0; i < A.size(); i++){
            long max = (long)(i - ngl.get(i)) * (long)(ngr.get(i) - i);
            long min = (long)(i - nsl.get(i)) * (long)(nsr.get(i) - i);
            sum += ((max-min) * A.get(i));
        }
        return (int)(sum%mod);
    }

    private static boolean getValidation(String conditionName, Stack<Integer> stack, ArrayList<Integer> A, Integer index) {
        if (conditionName.contains("min")) {
            return A.get(stack.peek()) >= A.get(index);
        }
        return A.get(stack.peek()) <= A.get(index);
    }

    private static ArrayList<Integer> generateLeft(ArrayList<Integer> A, String condition) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> ans = new ArrayList();

        for (int i = 0; i < A.size(); i++) {
            while (!stack.empty() && getValidation(condition, stack, A, i)) {
                stack.pop();
            }

            if (stack.empty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(i);
        }
        return ans;
    }

    private static ArrayList<Integer> generateRight(ArrayList<Integer> A, String condition) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> ans = new ArrayList();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.empty() && getValidation(condition, stack, A, i)) {
                stack.pop();
            }

            if (stack.empty()) {
                ans.add(A.size());
            } else {
                ans.add(stack.peek());
            }

            stack.push(i);
        }

        Collections.reverse(ans);
        return ans;
    }
}
