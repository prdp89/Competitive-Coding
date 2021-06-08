package com.coding.leetcode.contests.weekely.weekely224;

import java.util.HashMap;
import java.util.Map;

public class LargestRect {

    public static void main( String[] args ) {
        int[][] rect = {
                {5, 8},
                {3, 9},
                {5, 12},
                {16, 5}
        };

        System.out.println(countGoodRectangles(rect));
    }

    private static int countGoodRectangles( int[][] rectangles ) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int[] rect : rectangles) {
            int temp = Math.min(rect[0], rect[1]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, temp);
        }

        return map.get(max);
    }
}
