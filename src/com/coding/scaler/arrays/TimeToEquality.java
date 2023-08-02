package com.coding.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeToEquality {

    /**
     * Given an integer array A of size N. In one second, you can increase the value of one element by 1.
     * <p>
     * Find the minimum time in seconds to make all elements of the array equal.
     * <p>
     * Example Input
     * A = [2, 4, 1, 3, 2]
     * <p>
     * <p>
     * Example Output
     * 8
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 4, 1, 3, 2));

        System.out.println(solve(list));

        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(-2, 1, -4, 5, 3));
        //op = 1 => 5 + -4
        System.out.println("maxmin:" + solveSumOfMaxAndMinInArr(list2));


        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(2, 1, 2));
        System.out.println("secondmax:" + solveSecondLargestInArr(list3));
    }

    private static int solve(List<Integer> list) {
        int max = -1;

        for (Integer integer : list) {
            max = Math.max(max, integer);
        }

        int total = 0;
        for (Integer integer : list) {
            if (max != integer)
                total += Math.abs(integer - max);
        }

        return total;
    }

    private static int solveSumOfMaxAndMinInArr(List<Integer> list) {
        int max = Integer.MIN_VALUE, min =Integer.MAX_VALUE;

        for (Integer integer : list) {
            max = Math.max(max, integer);
            min = Math.min(min, integer);
        }

        return max + min;
    }

    private static int solveSecondLargestInArr(List<Integer> list) {
        if(list.size() == 1)
            return -1;

        int max = Integer.MIN_VALUE, secondMax = -1;

        for (Integer integer : list) {
            max = Math.max(max, integer);
        }

        for (Integer integer : list) {
            if(list.get(integer) != max)
            secondMax = Math.max(secondMax, integer);
        }

        return secondMax;
    }

}
