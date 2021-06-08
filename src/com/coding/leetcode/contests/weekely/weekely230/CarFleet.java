package com.coding.leetcode.contests.weekely.weekely230;

import java.util.Arrays;

public class CarFleet {

    //https://leetcode.com/problems/car-fleet/
    public static void main( String[] args ) {
        int target = 12, position[] = {10, 8, 0, 5, 3}, speed[] = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

    //Runtime: 16 ms, faster than 52.93% of Java
    //if two cars arrives at same position they form a fleet
    private static int carFleet( int target, int[] position, int[] speed ) {
        int n = position.length, res = 0;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) { //speed = distance / time and time = distance / speed
            cars[i] = new double[]{position[i],
                    (double) (target - position[i]) / speed[i]}; //we need to find distance w.r.t target, so:(target - position[i])
        }

        //sort acc. to current position position[i]
        Arrays.sort(cars, ( a, b ) -> (int) (a[0] - b[0]));

        double curPos = 0;

        for (int i = n - 1; i >= 0; i--) {

        /*
        If another car needs more time,
        it will be the new slowest car,
        and becomes the new lead of a car fleet.
         */
            if (cars[i][1] > curPos) {
                curPos = cars[i][1];
                res++;
            }
        }

        return res;
    }
}
