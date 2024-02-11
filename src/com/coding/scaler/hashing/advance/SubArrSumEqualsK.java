package com.coding.scaler.hashing.advance;

import java.util.HashMap;

public class SubArrSumEqualsK {

    /**
     * Given an array of integers A and an integer B.
     * Find the total number of subarrays having sum equals to B.
     *
     * nput 1:
     * A = [1, 0, 1]
     * B = 1
     *
     * Output 1:
     * 4
     *
     * Explanation 1:
     * [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1,0,1}, 1));
    }

    private static int solve(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, totalCount = 0;

        //instead of this if (sum == k) condition we can use:
        //map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                totalCount++;

            if (map.containsKey(sum - k))
                totalCount += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return totalCount;
    }
}
