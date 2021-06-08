package com.coding.leetcode.contests.weekely.weekely241;

public class SumAllXorSubsets {

    public static void main( String[] args ) {
        subsetXORSum(new int[]{3, 4, 5, 6, 7, 8});
        subsetXORSum_include_exclude(new int[]{3, 4, 5, 6, 7, 8});

        System.out.println(subsetXORSum_bits(new int[]{3, 4, 5, 6, 7, 8}));
    }

    //48 / 48 test cases passed.
    //Status: Accepted
    //Runtime: 0 ms
    private static void subsetXORSum( int[] nums ) {
        System.out.println(dfs(0, 0, nums));
    }

    private static int dfs( int i, int total, int[] nums ) {
        if (i == nums.length)
            return total;

        int temp = total;
        for (int k = i; k < nums.length; k++) {
            temp += dfs(k + 1, total ^ nums[k], nums);
        }

        return temp;
    }

    private static int subsetXORSum_bits(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }

        return res * (1 << nums.length - 1);
    }

    private static void subsetXORSum_include_exclude( int[] nums ) {
        System.out.println(getAns(nums, 0, 0));
    }

    static int getAns( int[] arr, int i, int cur ) {
        if (i == arr.length) {
            return cur;
        }

        return getAns(arr, i + 1, cur ^ arr[i]) + getAns(arr, i + 1, cur);
    }
}
