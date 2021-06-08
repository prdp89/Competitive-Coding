package com.coding.leetcode.contests.biweekely.biweekely47;

import java.util.Arrays;

public class NearestPointXYCord {

    //https://leetcode.com/contest/biweekly-contest-47/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
    public static void main( String[] args ) {
        int[][] points = {
                {1, 2},
                {3, 1},
                {2, 4},
                {2, 3},
                {4, 4}
        };
        int x = 3, y = 4;

        System.out.println(nearestValidPoint(x, y, points));
    }

    private static int nearestValidPoint( int x, int y, int[][] points ) {
        int[] res = new int[points.length];
        int i = 0;
        for (int[] point : points) {
            int dist = Math.abs(point[0] - x) + Math.abs(point[1] - y);
            res[i++] = dist;
        }

        Arrays.sort(res);

        int ot = res[0];
        if (ot == 0)
            return 0;

        return 0;
    }

    private static int nearestValidPoint_optimal( int x, int y, int[][] points ) {
        int index = -1;

        for (int i = 0, smallest = Integer.MAX_VALUE; i < points.length; ++i) {

            int dx = x - points[i][0], dy = y - points[i][1];

            //technique to identify if x or y co-ordinate is shared - dx*dy==0
            if (dx * dy == 0 && Math.abs(dy) + Math.abs(dx) < smallest) {
                smallest = Math.abs(dx) + Math.abs(dy);
                index = i;
            }
        }

        return index;
    }
}