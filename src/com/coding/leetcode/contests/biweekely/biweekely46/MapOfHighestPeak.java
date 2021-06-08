package com.coding.leetcode.contests.biweekely.biweekely46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    //https://leetcode.com/contest/biweekly-contest-46/problems/map-of-highest-peak/
    public static void main( String[] args ) {
        int[][] matrix = {
                {0, 1},
                {0, 0}
        };

        System.out.println(Arrays.deepToString(highestPeak(matrix)));
    }

    //standard BFS approach
    //Runtime: 45 ms
    //Memory Usage: 146.7 MB
    private static int[][] highestPeak( int[][] isWater ) {
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //fill each water cell to zero
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        int[] dir = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int r = item[0], c = item[1];

            //now circle in four direction
            for (int i = 0; i < 4; i++) {
                int currR = r + dir[i], currC = c + dir[i + 1];

                //check boundary
                if (currR < 0 || currC < 0 || currR >= m || currC >= n || height[currR][currC] != -1)
                    continue;

                //adjacent cell should be greater than existing
                height[currR][currC] = height[r][c] + 1;
                queue.offer(new int[]{currR, currC});
            }
        }

        return height;
    }
}
