package com.coding.leetcode.contests.weekely.weekely232;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAvgPassRatio {

    //https://leetcode.com/problems/maximum-average-pass-ratio/
    public static void main( String[] args ) {
        int[][] classes = {
                {1, 2},
                {3, 5},
                {2, 2}
        };
        int exSt = 2;

        System.out.println(maxAverageRatio(classes, exSt));
    }

    //TIME: O(M*logN + N*logN)
    private static double maxAverageRatio( int[][] classes, int extraStudents ) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0])); // Max heap compared by first value in decreasing order.
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            maxHeap.offer(new double[]{profit(a, b), a, b});
        }

        //greedily assigning 1 extra student
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];

            //adding 1 extra student to each class
            maxHeap.offer(new double[]{profit(a + 1, b + 1), a + 1, b + 1});
        }

        double ans = 0.0d;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            ans += a / b;
        }

        return ans / classes.length;
    }

    private static double profit( double a, double b ) {
        return (a + 1) / (b + 1) - a / b; //need (a+1) bcz a/a will be zero..
    }
}
