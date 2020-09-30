package com.coding.binarysearch.arrays.greedy;

public class GasStation {

    //https://leetcode.com/problems/gas-station/
    public static void main( String[] args ) {
        int[] gas = {1, 2, 3, 4, 5}; //total gas amount at ith station
        int[] cost = {3, 4, 5, 1, 2}; //gas cost to reach ith to i + 1 station

        System.out.println(canCompleteCircuit(gas, cost));
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    private static int canCompleteCircuit( int[] gas, int[] cost ) {
        int sumGas = 0, sumCOst = 0, start = 0, tank = 0;

        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCOst += cost[i];

            //a tank can only fill totalgas - costToReach next destination
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if (sumGas < sumCOst) {
            return -1;
        }

        return start;
    }
}
