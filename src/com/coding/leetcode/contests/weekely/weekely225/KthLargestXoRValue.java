package com.coding.leetcode.contests.weekely.weekely225;

import java.util.PriorityQueue;

public class KthLargestXoRValue {

    public static void main( String[] args ) {
        int[][] matrix = {
                {5, 2},
                {1, 6}
        };
        int k = 1;

        System.out.println(kthLargestValue(matrix, k));
    }

    //https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
    //https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/discuss/1032010/Detailed-Explanation-or-C%2B%2B-Solution-or-Easy-Implementation

    //Runtime: 220 ms, faster than 20.00% of Java online
    private static int kthLargestValue( int[][] matrix, int k ) {
        int i, j, n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 1
        for (i = 0; i < n; i++) {
            for (j = 1; j < m; j++) {
                matrix[i][j] = matrix[i][j - 1] ^ matrix[i][j];
            }
        }

        // Step 2
        for (i = 0; i < m; i++) {
            for (j = 1; j < n; j++) {
                matrix[j][i] = matrix[j - 1][i] ^ matrix[j][i];
            }
        }

        // Step 3
        //logic same as https://leetcode.com/submissions/detail/340662738/
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
