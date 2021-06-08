package com.coding.leetcode.contests.biweekely.biweekely50;

import java.util.Arrays;

public class PointsInsideCircle {

    //https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
    public static void main( String[] args ) {
        int[][] points = {
                {1, 3},
                {3, 3},
                {5, 3},
                {2, 2}
        };

        int[][] queries = {
                {2, 3, 1},
                {4, 3, 1},
                {1, 1, 2}
        };

        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    //distance between two points (x1, y1) and (x2, y2) is given by - sqrt((x1 - x2)^2 + (y1 - y2)^2)
    //Thus, we need - (circle_center_x - x1) ^ 2 - (circle_center_y - y1) ^ 2 <= r * r for a point to be inside the circle.
    private static int[] countPoints( int[][] points, int[][] queries ) {
        int[] res = new int[queries.length];

        int i = 0;
        for (int[] query : queries) {
            int x = query[0], y = query[1], r = query[2] * query[2];

            for (int[] point : points) {
                int dist = (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]);

                if (dist <= r) {
                    res[i]++;
                }
            }
            i++;
        }

        return res;
    }
}
