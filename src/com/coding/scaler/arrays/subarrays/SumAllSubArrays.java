package com.coding.scaler.arrays.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumAllSubArrays {

    /**
     * You are given an integer array A of length N.
     * You have to find the sum of all subarray sums of A.
     *
     * Note :
     * 1. Try to figure out the contribution of A[i] in the sum of all subarray sums.
     * 2. In another word, for A[i], try to find count of A[i] in entire subarray sums.
     *
     * Input 1:
     * A = [1, 2, 3]
     *
     * Example Output
     * Output 1:
     * 20
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(subarraySum(list));
    }

    /**
     * This method uses contribution technique explained in class, Formula:
     *
     * if Index is K = (K + 1) *  (N - K)
     *
     * it means how many times index K exists in an array, then just multiply that K with A[i]
     * @param list
     * @return
     */
    private static Long subarraySum(List<Integer> list) {
        int n = list.size();
        long sum = 0, count = 0;
        for (int i=0; i<list.size(); i++) {
            count = (long) (i + 1) * (n-i);
            sum += list.get(i) * count;
        }
        return sum;
    }
}
