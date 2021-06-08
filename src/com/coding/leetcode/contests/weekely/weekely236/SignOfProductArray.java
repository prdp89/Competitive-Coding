package com.coding.leetcode.contests.weekely.weekely236;

public class SignOfProductArray {

    public static void main( String[] args ) {
        int[] nums = {-1,1,-1,1,-1};
        System.out.println( arraySign(nums));
    }

    private static int arraySign( int[] nums ) {
        int countNegative = 0;
        for (int num : nums) {
            if (num == 0)
                return 0;
            else if(num < 0) {
                countNegative++;
            }
        }

        return countNegative % 2 == 0 ? 1 : -1;
    }
}
