package com.coding.leetcode.contests.biweekely.biweekely49;

import java.util.HashMap;
import java.util.Map;

public class MaxGroupFreshDonuts {

    //https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/discuss/1146819/Step-by-Step-to-Solve-This-Problem
    Map<String, Integer> map = new HashMap<>();


    //73 / 73 test cases passed.
    //Status: Accepted
    //Runtime: 546 ms
    //https://leetcode.com/contest/biweekly-contest-49/problems/maximum-number-of-groups-getting-fresh-donuts/
    public static void main( String[] args ) {
        MaxGroupFreshDonuts max = new MaxGroupFreshDonuts();
        System.out.println(max.maxHappyGroups(3, new int[]{1, 2, 3, 4, 5, 6}));
    }

    public int maxHappyGroups( int batchSize, int[] groups ) {
        int[] count = new int[batchSize];

        //MOD with batchSize helps to find total satisfied persons at zero'th index
        for (int x : groups) {
            count[x % batchSize]++;
        }

        // count[0] means if we set those group in front of others, all those group can eat fresh dounts
        return count[0] + dfs(count, 0, count[0], groups.length);
    }

    public int dfs( int[] count, int preSum, int i, int n ) {
        if (i == n)
            return 0;

        int ret = 0;
        String key = getKey(count);

        if (map.containsKey(key))
            return map.get(key);

        //help to calc remaining group satisfied person.
        int bonus = preSum % count.length == 0 ? 1 : 0; //or preSum % batchSize

        for (int j = 1; j < count.length; j++) {
            if (count[j] == 0) //if no batch found at index
                continue;

            count[j]--;
            ret = Math.max(ret, dfs(count, preSum + j, i + 1, n));
            count[j]++;
        }

        map.put(key, ret + bonus);
        return ret + bonus;
    }

    public String getKey( int[] count ) {
        StringBuilder sb = new StringBuilder();
        for (int x : count) {
            sb.append(x).append("-");
        }
        return sb.toString();
    }
}
