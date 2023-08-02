package com.coding.scaler.arrays.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenAllSubArrays {

    /**
     * You are given an array A of N integers.
     * Return a 2D array consisting of all the subarrays of the array
     * <p>
     * Input 1:
     * A = [1, 2, 3]
     * <p>
     * Output 1:
     * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
     */
    public static void main(String[] args) {
        //ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        //solve(list2).forEach(System.out::println);

        //ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5));
        //System.out.println(solveMaxSubArray(list2, 12));

    }

    private static ArrayList<ArrayList<Integer>> solve(List<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            for (int j = i; j < list.size(); j++) {
                ArrayList<Integer> temp = new ArrayList<>();

                for (int k = i; k <= j; k++) {
                    temp.add(list.get(k));
                }
                res.add(temp);
                //temp.add(list.get(j));
            }
        }
        return res;
    }

    /**
     * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
     * But the sum must not exceed B.
     * @param list
     * @param B
     * @return
     */
    private static int solveMaxSubArray(List<Integer> list, int B) {
        int ans = -1, A = list.size();
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += list.get(j);
                if (sum <= B)
                    ans = Math.max(ans, sum);
                else break;
            }
        }
        return ans;
    }
}
