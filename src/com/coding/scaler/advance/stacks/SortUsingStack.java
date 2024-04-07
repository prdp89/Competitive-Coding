package com.coding.scaler.advance.stacks;

import java.util.Arrays;
import java.util.Stack;

public class SortUsingStack {

    /**
     * Given a stack of integers A, sort it using another stack.
     *
     * Return the array of integers after sorting the stack using another stack.
     *
     * Input 1:
     *
     *  A = [5, 4, 3, 2, 1]
     *
     *  Output 1:
     *
     *  [1, 2, 3, 4, 5]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {5, 4, 3, 2, 1})));
    }

    private static int[] sort(int[] A) {
        Stack<Integer> stack = new Stack();
        for(int item: A) {
            stack.push(item);
        }

        Stack<Integer> temp = new Stack();

        int [] res = new int[A.length];

        while(!stack.isEmpty()) {
            int x = stack.pop();

            //if prev element is greater than current, no use pop it
            while(!temp.isEmpty() && temp.peek() > x) {
                stack.push(temp.pop());
            }

            temp.push(x);
        }

        for (int i = A.length-1; i>=0; i--) {
            res[i] = temp.pop();
        }
        return res;
    }
}
