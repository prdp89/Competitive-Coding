package com.coding.leetcode.contests.weekely.weekely227;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ClosestSubSeqSum {

    //https://leetcode.com/contest/weekly-contest-227/problems/closest-subsequence-sum/
    public static void main( String[] args ) {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;

        System.out.println(minAbsDifference(nums, goal));
    }

    private static int minAbsDifference( int[] nums, int goal ) {
        Set<Integer> leftSet = new HashSet<>(); // {0 ,-2, 7, -9}
        Set<Integer> rightSet = new HashSet<>(); // {0, -2, 13, 15}

        generate(0, nums.length / 2, nums, 0, leftSet);
        generate(nums.length / 2, nums.length, nums, 0, rightSet);

        TreeSet<Integer> ts = new TreeSet<>(rightSet);
        int ans = Math.abs(goal);

        for (int left : leftSet) {
            int right = goal - left;
            if (ts.contains(right)) {
                return 0;
            }

            //lower/higher differ than ceiling/floor
            //Definition: Higher returns the greatest key for the specified key.
            // Lower key returns the greatest key that is less than the specified key.
            //eg {c, m, p, s}
            //higher(m) : p ; lower(m) : c

            //ceil/floor
            //Ceiling returns the least(kam se kam) key that is greater than or equal to the specified key.
            // Floor returns the greatest key that is less or equal to the specified key.
            //eg {c, m, p, s}
            //ceiling(r) : s ; floor(r) : p

            Integer right1 = ts.lower(right);
            Integer right2 = ts.higher(right);

            if (right1 != null) {
                ans = Math.min(ans, Math.abs(left + right1 - goal));
            }
            if (right2 != null) {
                ans = Math.min(ans, Math.abs(left + right2 - goal));
            }
        }

        return ans;
    }

    /**
     * Generating all possible subset sums. 2 choices at each index,i -> pick vs do not pick
     */
    private static void generate( int pos, int stop, int[] nums, int sum, Set<Integer> set ) {
        if (pos == stop) {
            set.add(sum);
            return;
        }
        generate(pos + 1, stop, nums, sum, set);
        generate(pos + 1, stop, nums, sum + nums[pos], set);
    }
}
