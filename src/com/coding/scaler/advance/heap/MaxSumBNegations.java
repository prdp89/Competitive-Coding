package com.coding.scaler.advance.heap;

import java.util.PriorityQueue;

public class MaxSumBNegations {

    /**
     * Given an array of integers A and an integer B. You must modify the array exactly B number of times.
     * In a single modification, we can replace any one array element A[i] by -A[i].
     *
     * You need to perform these modifications in such a way that after exactly B modifications,
     * sum of the array must be maximum.
     *
     * NOTE: You can perform the modification on the same element multiple times.
     *
     * Input 1:
     *
     *  A = [24, -68, -29, -9, 84]
     *  B = 4
     *
     *  Output 1:
     *
     *  196
     *
     *  Explanation 1:
     *
     *
     * Operation 1: Make -29 to 29,
     * Operation 2: Make -9 to 9,
     * Operation 3: Make 9 to -9,
     * Operation 4: Make -68 to 68.
     * Thus, the final array after 4 modifications = [24, 68, 29, -9, 84]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {24, -68, -29, -9, 84}, 4));
    }

    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int item:A) {
            pq.add(item);
        }

        //now convert B items to -val
        while (B-- > 0 && !pq.isEmpty()) {
            int val = pq.poll();
            val *= -1;
            pq.offer(val);
        }

        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}
