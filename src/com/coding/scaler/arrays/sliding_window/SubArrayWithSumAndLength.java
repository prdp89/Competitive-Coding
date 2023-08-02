package com.coding.scaler.arrays.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithSumAndLength {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 2, 5, 1));
        int B = 4, C = 6;
        System.out.println(solve(list, B, C));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 7, 5, 20, -10, 0, 12));

        System.out.println(solveLeastAverage(list2, 2));
    }

    /**
     * Given an array A of length N. Also given are integers B and C.
     * <p>
     * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
     * <p>
     * Input 1:
     * A = [4, 3, 2, 6, 1]
     * B = 3
     * C = 11
     * <p>
     * Output 1:
     * 1
     * <p>
     * Explanation 1:
     * The subarray [3, 2, 6] is of length 3 and sum 11.
     */
    private static int solve(ArrayList<Integer> list, int B, int C) {
        int n = list.size();
        if (B > n)
            return 0;

        int sum = 0;
        for (int i = 0; i < B; i++)
            sum += list.get(i);

        if (sum == C)
            return 1;

        int start = 1, end = B;
        while (end < n) {

            sum = sum - list.get(start - 1) + list.get(end);

            if (sum == C)
                return 1;

            end++;
            start++;
        }

        return 0;
    }

    /**
     * Given an array of size N, find the subarray of size K with the least average.
     *
     * Input 1:
     * A=[3, 7, 90, 20, 10, 50, 40]
     * B=3
     *
     * Output 1:
     * 3
     *
     * Subarray between indexes 3 and 5
     * The subarray {20, 10, 50} has the least average
     * among all subarrays of size 3.
     *
     * Also a GFG problem: https://www.geeksforgeeks.org/find-subarray-least-average/
     */
    private static int solveLeastAverage(ArrayList<Integer> list, int B) {
        int n = list.size();
        if (B > n)
            return 0;

        int sum = 0;
        for (int i = 0; i < B; i++)
            sum += list.get(i);

        if (list.size() == B)
            return 0;

        int start = 1, end = B, min = sum, index = 0;
        while (end < n) {

            sum = sum - list.get(start - 1) + list.get(end);

            if (sum  < min) {
                min = sum;
                index = start;
            }

            end++;
            start++;
        }

        return index;
    }
}
