package com.coding.leetcode.contests.weekely.weekely235;

import java.util.*;

public class UniqueActiveMins {

    //https://leetcode.com/contest/weekly-contest-235/problems/finding-the-users-active-minutes/
    public static void main( String[] args ) {
        int[][] logs = {
                {0, 5},
                {1, 2},
                {0, 2},
                {0, 5},
                {1, 3}
        };
        int k = 5;

       /* int[][] logs = {
                {1, 1},
                {2, 2},
                {2, 3}
        };
        int k = 4;*/

        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }

    private static int[] findingUsersActiveMinutes( int[][] logs, int k ) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            map.putIfAbsent(logs[i][0], new HashSet<>());
            map.get(logs[i][0]).add(logs[i][1]);
        }

        int[] bucket = new int[k];
        //int[] res = new int[k + 1];
        for (int key : map.keySet()) {
            bucket[map.get(key).size() - 1]++;
        }
        return bucket;
    }
}
