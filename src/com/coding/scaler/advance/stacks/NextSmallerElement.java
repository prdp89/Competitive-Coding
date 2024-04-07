package com.coding.scaler.advance.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    /**
     * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
     *
     * More formally,
     *
     * G[i] for an element A[i] = an element A[j] such that
     *
     * j is maximum possible AND
     *
     * j < i AND
     *
     * A[j] < A[i]
     *
     * Elements for which no smaller element exist, consider the next smaller element as -1.
     *
     * Input 1:
     *
     *  A = [4, 5, 2, 10, 8]
     *
     *  Output 1:
     *
     *  [-1, 4, -1, 2, 2]
     *
     *  Explanation 1:
     *
     * index 1: No element less than 4 in left of 4, G[1] = -1
     * index 2: A[1] is only element less than A[2], G[2] = A[1]
     * index 3: No element less than 2 in left of 2, G[3] = -1
     * index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
     * index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(prevSmaller(new int[] {4, 5, 2, 10, 8})));
    }

    private static int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack();

        int [] res = new int[A.length];
        int i=0;
        for(int num: A) {

            //if prev element is greater than current, no use pop it
            while(!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                //else add peek() element to array which is smaller than current
                res[i] = stack.peek();
            } else {
                res[i] = -1;
            }

            //storing current element.
            stack.push(num);
            i++;
        }
        return res;
    }
}
