package com.coding.binarysearch.arrays.prefix;

public class SmallestPairSum {

    //https://binarysearch.com/problems/Smallest-Pair-Sum-with-Distance-Constraint
    public static void main( String[] args ) {
        int[] nums = {3, 1, 0, 0};

        //System.out.println(solve(nums));
        System.out.println(solve_optimal(nums));
    }

    //Your submission was faster than 84.09% of other Java
    private static int solve_optimal( int[] nums ) {

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.min(prefix[i - 1], nums[i]);
        }

        int minSum = Integer.MAX_VALUE;
        //same as my nested loop logic
        for (int i = 2; i < nums.length; i++) {
            minSum = Math.min(minSum, prefix[i - 2] + nums[i]);
        }

        return minSum;
    }

    private static int solve( int[] nums ) {
        int sum = Integer.MAX_VALUE, index0 = -1, sum1 = Integer.MAX_VALUE;

        /*for (int i = 0; i < nums.length; i++) {

            if (nums[i] < sum) {
                for (int j = i + 2; j < nums.length; j++) {
                    sum = Math.min(sum, nums[i] + nums[j]);
                }
            }
        }*/

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= sum) {
                sum = nums[i];
                index0 = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= sum && nums[i] < sum1 && Math.abs(index0 - i) > 1) {
                sum1 = nums[i];
            }
        }

        if (nums.length == 3) {
            int first = nums[0] + nums[2];
            return Math.min(first, sum + sum1);
        }

        return sum + sum1;
    }
}
