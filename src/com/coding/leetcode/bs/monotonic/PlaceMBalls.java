package com.coding.leetcode.bs.monotonic;

import java.util.Arrays;

public class PlaceMBalls {

    //https://leetcode.com/problems/magnetic-force-between-two-balls/
    public static void main( String[] args ) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;

        System.out.println(maxDistance(position, m));
    }

    //We have to find Max(min_diff_bw_2_balls)
    //If array if sorted then this difference is easy
    //And we have to place M ball at positions..

    //Runtime: 43 ms, faster than 65.96% of Java
    private static int maxDistance( int[] position, int m ) {
        Arrays.sort(position);
        int low = 1;
        int hi = position[position.length - 1]; // since array is sorted then max possible distance can be first and last element

        int ans = -1;
        while (low <= hi) {

            int mid = low + (hi - low) / 2; //this mid is monotonic increasing..

            if (canPlace(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private static boolean canPlace( int[] position, int noOfBalls, int minDistance ) {
        int lastPos = position[0]; // first ball at 0 position - keep track of last position
        int idx = 1;
        noOfBalls--; // we have placed first ball at 0 position

        while (idx < position.length && noOfBalls > 0) {
            /* if minDistance between last position and position at idx is greater then or equal to minDistance
             *  then place the ball else skip
             * */
            if (position[idx] - lastPos >= minDistance) {
                lastPos = position[idx];
                noOfBalls--;
            }

            idx++;
        }
        return noOfBalls == 0; /*if all balls have been placed then return true else false*/
    }
}
