package com.coding.scaler.hashing;

import java.util.HashMap;

public class CountSubArrayZeroSum {

    /**
     * Given an array A of N integers.
     *
     * Find the count of the subarrays in the array which sums to zero.
     * Since the answer can be very large, return the remainder on dividing the result with 109+7
     *
     * Input 1:
     *  A = [1, -1, -2, 2]
     *
     *  Output 1:
     *  3
     *
     *  Explanation 1:
     *  The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1, -1, -2, 2}));
    }

    private static int solve(int[] arr) {
        int n = arr.length;
        HashMap<Long, Integer> map = new HashMap();

        //bcz zero sum can exist atleast once, this is also req. to make zero-sum combination.
        map.put(0L, 1);

        Long sum = 0L;
        int ans = 0;

        for (int i=0; i< n; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                ans += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans % (int)(1e9 + 7);
    }
}
