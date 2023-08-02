package com.coding.scaler.hashing;

import java.util.HashMap;

public class CountPairSum {

    /**
     * You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.
     *
     * Since the answer can be very large, return the remainder after dividing the count with 109+7.
     *
     * Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
     *
     *
     * Input 1:
     *
     * A = [3, 5, 1, 2]
     * B = 8
     *
     * Output 1:
     *
     * 1
     *
     * Example 1:
     *
     * The only pair is (1, 2) which gives sum 8
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {3, 5, 1, 2}, 8));
    }

    private static int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap();

        int ans = 0;
        for(int item: A) {
            int diff = B - item;
            if(map.containsKey(diff)) {
                ans +=  map.get(diff);
            }
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        return (ans % (int) (1e9 + 7));
    }

}
