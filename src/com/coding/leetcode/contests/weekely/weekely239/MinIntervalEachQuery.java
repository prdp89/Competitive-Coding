package com.coding.leetcode.contests.weekely.weekely239;

import java.util.*;

public class MinIntervalEachQuery {

    //https://leetcode.com/contest/weekly-contest-239/problems/minimum-interval-to-include-each-query/
    public static void main( String[] args ) {
        int[][] intervals = {
                {1, 4},
                {2, 4},
                {4, 4},
                {3, 6}
        };
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(minInterval(intervals, queries)));
    }

    /*
    Since we want the smallest size of the interval, we can use Priority Queue sorted by the size of the window.
    But we should only have valid intervals in the queue. So we need to sort both intervals and queries in the first place.
     */

    //Runtime: 139 ms, faster than 47.77% of Java
    private static int[] minInterval( int[][] intervals, int[] queries ) {
        int[] res = new int[queries.length];
        List<Integer> sortedQueryIndex = new ArrayList<>();

        for (int i = 0; i < queries.length; i++)
            sortedQueryIndex.add(i);

        //sort by queries ascending..
        sortedQueryIndex.sort(Comparator.comparingInt(a -> queries[a]));

        //sort by queries ascending..
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //[size of interval, end of interval]
        //sort by size of interval in PQ
        PriorityQueue<int[]> q = new PriorityQueue<>(( a, b ) -> (a[0] - b[0]));

        int i = 0;
        for (int j = 0; j < queries.length; j++) {
            int query = queries[sortedQueryIndex.get(j)];

            //store the Interval size in PQ[0] and intervals[1] in PQ[1]
            while (i < intervals.length && intervals[i][0] <= query) {
                q.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }

            //if end of Interval is less than current query; remove from PQ
            while (!q.isEmpty() && q.peek()[1] < query)
                q.poll();

            //store the first relevant candidate in result array.
            if (q.isEmpty()) {
                res[sortedQueryIndex.get(j)] = -1;
            } else {
                res[sortedQueryIndex.get(j)] = q.peek()[0];
            }
        }

        return res;
    }
}
