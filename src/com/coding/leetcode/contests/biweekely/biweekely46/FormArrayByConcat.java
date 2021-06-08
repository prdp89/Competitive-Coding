package com.coding.leetcode.contests.biweekely.biweekely46;

public class FormArrayByConcat {

    //https://leetcode.com/contest/biweekly-contest-46/problems/form-array-by-concatenating-subarrays-of-another-array/
    public static void main( String[] args ) {
        int[][] groups = {
                {1, -1, -1},
                {3, -2, 0}
        };

        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        System.out.println(canChoose(groups, nums));
    }

    private static boolean canChoose( int[][] groups, int[] nums ) {
        int groupIndex = 0;
        for (int i = 0; i < nums.length && groupIndex < groups.length; i++) {
            //found first element in a group
            if (nums[i] == groups[groupIndex][0]) {

                int j = i, x = 0;
                while (j < nums.length && x < groups[groupIndex].length && nums[j] == groups[groupIndex][x]) {
                    j++;
                    x++;
                }

                //if found complete elements of groups in an array
                if (x == groups[groupIndex].length) {
                    groupIndex++;
                    i = j - 1;
                }
            }
        }

        return groupIndex == groups.length;
    }
}
