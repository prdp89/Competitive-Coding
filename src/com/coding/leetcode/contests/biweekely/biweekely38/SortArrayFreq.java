package com.coding.leetcode.contests.biweekely.biweekely38;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayFreq {

    //https://leetcode.com/contest/biweekly-contest-38/problems/sort-array-by-increasing-frequency/
    public static void main( String[] args ) {
        int[] nums = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        for (int i : frequencySort(nums)) {
            System.out.print(i + " ");
        }
    }

    private static int[] frequencySort( int[] nums ) {
        if (nums.length == 1)
            return nums;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(( a, b ) ->
                a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        for (int i = 0; i < nums.length && !pq.isEmpty(); i++) {
            int[] temp = pq.poll();
            nums[i] = temp[1];

            if (temp[0] > 1) {
                int count = temp[0];
                for (; i < nums.length && count > 0; count--)
                    nums[i++] = temp[1];

                i--;
            }
        }

        return nums;
    }
}
