package com.coding.scaler.arrays.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestMinMax {

    /**
     * Given an array A, find the size of the smallest subarray such that it contains at
     * least one occurrence of the maximum value of the array
     * and at least one occurrence of the minimum value of the array.
     * <p>
     * Input 1:
     * A = [1, 3, 2]
     * <p>
     * Output 1:
     * 2 // {1,3}
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2));

        System.out.println(solve(list));
    }

    private static int solve(List<Integer> list) {
        int min = Integer.MAX_VALUE, max = -1;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
            min = Math.min(min, list.get(i));
        }

        int ans = list.size(), min_i = -1, max_i = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == min) {
                min_i = i;
                if(max_i != -1) {
                    ans = Math.min(Math.abs(min_i - max_i) + 1, ans);
                }
            }

            if(list.get(i) == max) {
                max_i = i;
                if(min_i != -1) {
                    ans = Math.min(Math.abs(min_i - max_i) + 1, ans);
                }
            }
        }

        return ans;
    }
}
