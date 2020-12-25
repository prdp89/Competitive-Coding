package com.coding.leetcode.contests.monthlycontest.octcontest;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    //https://leetcode.com/problems/remove-covered-intervals/
    public static void main( String[] args ) {
        int[][] inter = {
                {1, 4},
                {3, 6},
                {2, 8}
        };

        //System.out.println(removeCoveredIntervals(inter));
        System.out.println(removeCoveredIntervals_optimal(inter));
    }

    //only passing 5 tests..shame :(
    private static int removeCoveredIntervals( int[][] intervals ) {
        int res = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {

            for (int j = i + 1; j < intervals.length && j > 0; j--) {
                if (intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]) {
                    res++;
                    break;
                }
            }
        }

        return intervals.length - res;
    }

    //Runtime: 4 ms, faster than 89.74% of Java
    /*
    https://leetcode.com/problems/remove-covered-intervals/discuss/451284/JavaPython-3-Simple-codes-w-explanation-and-analysis.

    Sort by the left bound, and when left bounds are equal, sort right bounds by reverse order;
    Therefore, "no interval can cover previous ones"

    Loop through the intervals, whenever current right most bound < next interval's right bound,
    it means current interval can NOT cover next interval, update right most bound and increase counter by 1.
     */
    private static int removeCoveredIntervals_optimal( int[][] intervals ) {
        //Read first:
        //Sorting by i[0] first bcz: covering occurs when c <= a, by sorting 'a' is always less than 'c'
        //If i[0] is equal then sort by desc of 'j' bcz covering occurs when b <= d. When we sort by desc of J[1] then 'b' is always greater
        Arrays.sort(intervals, ( i, j ) -> (i[0] == j[0] ? j[1] - i[1] : i[0] - j[0]));

        int count = 0, prev = 0;

        for (int[] a : intervals) {
            //if still current interval a[i] covering prev. interval : cur
            //THen we can update the answer
            if (prev < a[1]) {
                prev = a[1];
                ++count;
            }
        }
        return count;
    }
}
