package com.coding.leetcode.contests.weekely.weekely208;

public class MaxTransferRequests {

    private static int max = Integer.MIN_VALUE;

    //https://leetcode.com/contest/weekly-contest-208/problems/maximum-number-of-achievable-transfer-requests/
    public static void main( String[] args ) {
        int n = 5;
        int[][] req = {
                {0, 1},
                {1, 0},
                {0, 1},
                {1, 2},
                {2, 0},
                {3, 4}
        };

        System.out.println(maximumRequests(n, req));
    }

    //There are N request, so we have to generate combination of each request to check if Path exists between 2 or not
    //Recursive Pattern is same as Combination:https://leetcode.com/problems/combinations/
    private static int maximumRequests( int n, int[][] requests ) {
        // backtracking, subset
        // [0]++, [1]--.
        int[] count = new int[n];

        dfs(requests, 0, 0, count, "");
        return max;
    }

    private static void dfs( int[][] requests, int start, int num, int[] count, String s ) {
        if (start > requests.length) return;

        // System.out.println(s);

        // Traverse all n buildings to see if they are all 0. (means balanced)
        if (allZero(count)) {
            max = Math.max(max, num);
        }

        for (int i = start; i < requests.length; i++) {
            //If request came as :{1, 0} {0, 1}
            //Then count[1] = count[0] = 0 will be zero always
            count[requests[i][0]]++;
            count[requests[i][1]]--;

            // always make mistake that here should be i + 1, NOT start + 1
            dfs(requests, i + 1, num + 1, count, s + i);

            //backtrack..
            count[requests[i][0]]--;
            count[requests[i][1]]++;
        }
    }

    private static boolean allZero( int[] count ) {
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
}
