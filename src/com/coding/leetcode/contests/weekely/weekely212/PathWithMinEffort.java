package com.coding.leetcode.contests.weekely.weekely212;

import java.util.PriorityQueue;

public class PathWithMinEffort {

    //https://leetcode.com/contest/weekly-contest-212/problems/path-with-minimum-effort/
    //https://leetcode.com/problems/path-with-minimum-effort/
    public static void main( String[] args ) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(minimumEffortPath(heights));
    }

    //Runtime: 39 ms, faster than 84.46% of Java
    private static int minimumEffortPath( int[][] heights ) {
        final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //sort by min. distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a, b ) -> a[2] - b[2]);
        int n = heights.length;
        int m = heights[0].length;

        Integer[][] minDist = new Integer[n][m];
        minDist[0][0] = 0;

        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == n - 1 && cur[1] == m - 1)
                return cur[2];

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                int effort = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[x][y]));
                if (minDist[x][y] == null || minDist[x][y] > effort) {
                    minDist[x][y] = effort;
                    pq.offer(new int[]{x, y, minDist[x][y]});
                }
            }
        }

        return -1;
    }
}
