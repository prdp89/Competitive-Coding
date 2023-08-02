package com.coding.scaler.arrays.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TurnOnBulbs {

    /**
     * A wire connects N light bulbs.
     * <p>
     * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
     * <p>
     * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
     * <p>
     * You can press the same switch multiple times.
     * <p>
     * Note: 0 represents the bulb is off and 1 represents the bulb is on.
     * <p>
     * Input 1:
     * <p>
     * A = [0, 1, 0, 1]
     * <p>
     * Output 1:
     * <p>
     * 4
     * <p>
     * Explanation 1:
     * <p>
     * press switch 0 : [1 0 1 0]
     * press switch 1 : [1 1 0 1]
     * press switch 2 : [1 1 1 0]
     * press switch 3 : [1 1 1 1]
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 0, 1));

        System.out.println(bulbsBruteOptimal(list));

        System.out.println(bulbsBruteForce(list));

    }

    private static int bulbsBruteForce(ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            //if bulb is OFF then only toggle the remaining bulbs on the rt.
            if (list.get(i) == 0) {
                count++;
                for (int j = i; j < list.size(); j++) {
                    list.set(j, 1 - list.get(j));
                }
            }
        }

        return count;
    }

    private static int bulbsBruteOptimal(ArrayList<Integer> list) {
        /**
         *  [0 1 0 1] count = 0
         *  [1 0 1 0] count = 1
         *  [1 1 0 1] count = 2
         *  [1 1 1 0] count = 3
         *  [1 1 1 1] count = 4
         *
         *  observation 1: If count = 1 (even) state of bulb is toggled
         *  observation 1: If count = 2 (odd) state of bulb is same
         */

        int count = 0, state = 0;
        for (int i = 0; i < list.size(); i++) {

            //if ith element is toggled state then toggle the next elements as well.
            if (list.get(i) == state) {
                count++;
                // As we will switch this, all the bulbs on right side will also change. So, change state = 1 - state
                state = 1 - state;
            }
        }

        return count;
    }
}
