package com.coding.leetcode.contests.biweekely.biweekely37;

import java.util.PriorityQueue;

public class MeanOfArrayAfterFivePercent {

    //https://leetcode.com/contest/biweekly-contest-37/problems/mean-of-array-after-removing-some-elements/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(trimMean(arr));
    }

    //Runtime: 7MS, Memory: 39.2MB
    private static double trimMean( int[] nums ) {
        //nums.length = 20
        int remove = nums.length / 20; //remove = 1
        int remaining = nums.length - (remove * 2); //rem = 18

        PriorityQueue<Integer> maxs = new PriorityQueue<>(remove);
        PriorityQueue<Integer> mins = new PriorityQueue<>(remove, ( a, b ) -> b - a); //in desc order

        int sum = 0;

        for (int num : nums) {
            sum += num;

            mins.add(num);
            maxs.add(num);

            if (mins.size() > remove) {
                mins.remove();
                maxs.remove();
            }
        }

        while (remove-- > 0) {
            sum -= mins.remove();
            sum -= maxs.remove();
        }

        return sum / (double) remaining;
    }
}
