package com.coding.leetcode.contests.biweekely.biweekely37;

import java.util.PriorityQueue;

public class CoordinateMaxQuality {

    //https://leetcode.com/problems/coordinate-with-maximum-network-quality/
    public static void main( String[] args ) {
        int[][] towers = {
                {1, 2, 5},
                {2, 1, 7},
                {3, 1, 9}
        };

        int radius = 2;

        for (int i : bestCoordinate(towers, radius)) {
            System.out.print(i + " ");
        }
    }

    //https://leetcode.com/problems/coordinate-with-maximum-network-quality/discuss/898702/Try-all-x-y-coordinates-in-range-or-Detailed-Explanation
    //Runtime: 36 ms, faster than 44.94% of Java
    private static int[] bestCoordinate( int[][] towers, int radius ) {
        //if a[0] == b[0] == if quality is equal then
        //a[1] == b[1] == if X-axis are equal then sort by ASC of X-Axis else ASC of Y-Axis
        //else Sort by Desc of Quality.
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a, b ) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : b[0] - a[0]);

        //We have to check Towers in range of [51, 51] bcz quality signals cannot be in Towers itself(in worst case) :)
        for (int x = 0; x < 51; x++) {

            for (int y = 0; y < 51; y++) {
                int quality = 0;

                for (int j = 0; j < towers.length; j++) {
                    int xd = x - towers[j][0];
                    int yd = y - towers[j][1];

                    //euc. distance
                    double d = Math.sqrt(xd * xd + yd * yd);

                    //signal should be better than radius signal
                    if (d <= (double) radius) {
                        quality += (int) (towers[j][2] / (1 + d));
                    }
                }

                pq.add(new int[]{quality, x, y});
            }
        }

        //returning answer as [x, y] coordinate.
        return new int[]{pq.peek()[1], pq.peek()[2]};
    }
}
