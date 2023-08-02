package com.coding.scaler.advance.arrays;

import java.util.Map;

public class MaxAbsoluteDiff {

    /**
     * You are given an array of N integers, A1, A2, .... AN.
     *
     * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is
     * defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
     *
     * Input 1:
     * A = [1, 3, -1]
     *
     * Output 1:
     * 5
     *
     * Explanation 1:
     * f(1, 1) = f(2, 2) = f(3, 3) = 0
     * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
     * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
     * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
     *
     * So, we return 5.
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 3, -1}));
    }

    /**
     * Case 1: A[i] > A[j] and i > j
     * |A[i] - A[j]| = A[i] - A[j]
     * |i -j| = i - j
     * hence, f(i, j) = (A[i] + i) - (A[j] + j)
     *
     * Case 3: A[i] > A[j] and i < j
     * |A[i] - A[j]| = A[i] - A[j]
     * |i -j| = -(i) + j
     * hence, f(i, j) = (A[i] - i) - (A[j] - j)
     *
     */
    private static int solve(int [] A) {
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i=0; i<A.length; i++) {
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);

            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }
}
