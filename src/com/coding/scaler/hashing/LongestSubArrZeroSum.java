package com.coding.scaler.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubArrZeroSum {

    /**
     * Given an array A of N integers.
     * Find the length of the longest subarray in the array which sums to zero.

     Input 1:
     A = [1, -2, 1, 2]

     Output 1:
     3

     Explanation 1:
     [1, -2, 1] is the largest subarray which sums up to 0.
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1, -2, 1, 2}));
    }

    private static int solve(int[] A) {
        long [] prefix = new long[A.length];
        prefix[0] = A[0];

        for(int i=1; i<A.length; i++) {
            prefix[i] = prefix[i-1] + A[i];
        }

        int max_val = 0;
        HashMap<Long, Integer> map = new HashMap();
        for(int i=0; i < A.length; i++) {

            if(map.containsKey(prefix[i])) {
                max_val = Math.max(max_val, i - map.get(prefix[i]));
            }
            else {
                map.put(prefix[i], i);
            }

            //good corner case :)
            // Subarray starting from index 0
            if(prefix[i] == 0) {
                max_val = Math.max(max_val, i+1);
            }

        }
        return max_val;
    }
}
