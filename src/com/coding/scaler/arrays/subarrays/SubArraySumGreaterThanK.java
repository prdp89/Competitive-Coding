package com.coding.scaler.arrays.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 * <p>
 * Input 1:
 * <p>
 * A = [2, 5, 6]
 * B = 10
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * <p>
 * Explanation 1:
 * <p>
 * The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 */
public class SubArraySumGreaterThanK {

    public static void main(String[] args) {
        //TODO: Optimal is sliding window tech.

        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 5, 6));

        System.out.println(subarraySumCountBf(list2, 10));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(list, 4));
    }

    private static int subarraySumCountBf(List<Integer> list, int B) {
        int ans = -1, count = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if (sum < B)
                    count++;
                else break;
            }
        }
        return count;
    }

    /**
     * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
     * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
     * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
     * Your task is to find the count of good subarrays in A.
     *
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = 4
     *
     * Output 1:
     * 6
     *
     * Explanation 1:
     * Even length good subarrays = {1, 2}
     * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
     * @param list
     * @param B
     * @return
     */
    private static int solve(List<Integer> list, int B) {
        int ans = -1, count = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if ((j - i +1) % 2 == 0 && sum < B)
                    count++;
                else if ((j - i +1) % 2 != 0 && sum > B)
                    count++;

            }
        }
        return count;
    }
}
