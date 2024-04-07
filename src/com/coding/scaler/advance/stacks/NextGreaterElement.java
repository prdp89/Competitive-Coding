package com.coding.scaler.advance.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

    /**
     * Given an array A, find the next greater element G[i] for every element A[i] in the array.
     * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
     *
     * Input 1:
     *
     *  A = [4, 5, 2, 10]
     *
     *
     *  Output 1:
     *
     *  [5, 10, 10, -1]
     *
     */
    public static void main(String[] args) {
        generateRight(new ArrayList<>(Arrays.asList(4, 5, 2, 10))).forEach(System.out::println);
    }

    private static ArrayList<Integer> generateRight(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> ans = new ArrayList();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.empty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }

            if (stack.empty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(i);
        }

        Collections.reverse(ans);

        for(int i=0; i<A.size()-1; i++) {
            ans.set(i, ans.get(i) == -1 ? -1 : A.get(ans.get(i)));
        }
        return ans;
    }
}
