package com.coding.scaler.advance.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegers {

    /**
     * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
     *
     * NOTE: All the A integers will fit in 32-bit integers.
     *
     * Input 1:
     *
     *  A = 3
     *
     *  Output 1:
     *
     *  [1, 2, 3]
     *
     *  Explanation 1:
     *
     *  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
     *
     *  Input 2:
     *
     *  A = 7
     *
     *  Output 2:
     *
     *  [1, 2, 3, 11, 12, 13, 21]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(3)));
    }

    private static int[] solve(int A) {
        Queue<String> q =new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");

        int[] res =new int[A];
        int j=0;

        for( int i=1 ; i <= A ;i++) {
            String ele=q.peek();
            q.offer(ele + "1");
            q.offer(ele + "2");
            q.offer(ele + "3");
            res[j] = Integer.parseInt( q.poll());
            j++;
        }

        return res;
    }
}
