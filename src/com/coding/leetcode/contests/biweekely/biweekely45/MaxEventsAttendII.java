package com.coding.leetcode.contests.biweekely.biweekely45;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxEventsAttendII {

    //https://leetcode.com/contest/biweekly-contest-45/problems/maximum-number-of-events-that-can-be-attended-ii/
    public static void main( String[] args ) {
        int[][] events = {
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 1}
        };

        System.out.println(maxValue(events, 2));
    }

    //similar logic as Bounded-KnapSack
    private static int maxValue( int[][] events, int k ) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        Map<String, Integer> cache = new HashMap<>();
        return dfs(events, 0, 0, k, 0, cache);
    }

    private static int dfs( int[][] events, int cur, int count, int k, int end, Map<String, Integer> cache ) {
        if (count == k || cur == events.length) {
            return 0;
        }

        String key = count + "_" + end;
        Integer val = cache.get(key);
        if (val != null) {
            return val;
        }

        // skip
        int max = dfs(events, cur + 1, count, k, end, cache);

        //take only when current meeting start time greater than other's meeting ending..{don't conflict with ends meeting}
        if (events[cur][0] > end) {
            // take current
            max = Math.max(max, dfs(events, cur + 1, count + 1, k, events[cur][1], cache) + events[cur][2]);
        }

        cache.put(key, max);
        return max;
    }
}
