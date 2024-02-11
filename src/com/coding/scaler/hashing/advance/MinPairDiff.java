package com.coding.scaler.hashing.advance;

import java.util.HashMap;

public class MinPairDiff {

    /**
     * Shaggy has an array A consisting of N elements. We call a pair of distinct
     * indices in that array a special if elements at those indices in the array are equal.
     *
     * Shaggy wants you to find a special pair such that the distance between
     * that pair is minimum. Distance between two indices is defined as |i-j|.
     * If there is no special pair in the array, then return -1.
     *
     * Input 1:
     * A = [7, 1, 3, 4, 1, 7]
     *
     * Output 1:
     *  3
     *
     *
     *  Explanation 1:
     * Here we have 2 options:
     * 1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
     * 2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
     * Therefore the minimum possible distance is 3.
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {7, 1, 3, 4, 1, 7}));
    }

    private static int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<A.length; i++) {
            if(!map.containsKey(A[i])){
                map.put(A[i], i );
            } else {
               int prevIndex = map.get(A[i]);
               min = Math.min(min,  i - prevIndex);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
