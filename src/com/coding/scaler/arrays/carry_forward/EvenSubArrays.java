package com.coding.scaler.arrays.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenSubArrays {

    /**
     * You are given an integer array A.
     * <p>
     * Decide whether it is possible to divide the array into one or more subarrays
     * of even length such that the first and last element of all subarrays will be even.
     * <p>
     * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [2, 4, 8, 6]
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * "YES"
     * <p>
     * Explanation 1:
     * <p>
     * We can divide A into [2, 4] and [8, 6].
     */

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 8, 6));
        System.out.println(solve(list));
    }

    private static String solve(List<Integer> list) {
        if (list.size() == 1)
            return "NO";

        if (list.size() % 2 == 0 && list.get(0) % 2 == 0 && list.get(list.size() - 1) % 2 == 0) {
            return "YES";
        }

        return "NO";
    }

}
