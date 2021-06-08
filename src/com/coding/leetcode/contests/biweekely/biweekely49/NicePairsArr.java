package com.coding.leetcode.contests.biweekely.biweekely49;

import java.util.HashMap;
import java.util.Map;

public class NicePairsArr {

    //https://leetcode.com/contest/biweekly-contest-49/problems/count-nice-pairs-in-an-array/
    public static void main( String[] args ) {
        int[] nums = {42, 11, 1, 97};
        System.out.println(countNicePairs(nums));
    }

    //equation can be modified as: num[i] - rev(num[i]) = num[j] - rev(num[j])
    private static int countNicePairs( int[] nums ) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rev = Integer.parseInt(new StringBuilder().append(nums[i]).reverse().toString());
            int dif = nums[i] - rev;
            map.put(dif, map.getOrDefault(dif, 0) + 1);
        }

        long res = 0, m = 1000000007;
        for (int ct : map.values()) {
            if (ct == 1) continue; //for nums > 1 we can pair in: n*(n-1)/2 ways..
            res = (res + (long) ct * (ct - 1) / 2) % m;
        }

        return (int) res;
    }
}