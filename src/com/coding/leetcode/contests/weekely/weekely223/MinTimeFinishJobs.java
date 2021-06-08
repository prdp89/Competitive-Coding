package com.coding.leetcode.contests.weekely.weekely223;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MinTimeFinishJobs {

    private static int res = Integer.MAX_VALUE;

    //https://leetcode.com/contest/weekly-contest-223/problems/find-minimum-time-to-finish-all-jobs/
    //similar: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
    public static void main( String[] args ) {
        int[] jobs = {3, 2, 3};
        int k = 3;

        System.out.println(minimumTimeRequired(jobs, k));
    }

    //jobs = [1,2,4,7,8], k = 2
    //We have to find Min. possible of Max. working time. Options can be:

    //Options_1:
    //First worker can pick : 1, 2, 8 => 11 and since 3 works already done by worker_1
    //so second worker can pick only: 4 , 7 => 11

    //Options_2:
    //First worker can pick : 1, 4, 8 => 13 and since 3 works already done by worker_1
    //so second worker can pick only: 4 , 7 => 9

    //So answer wil be Min possible of Max(13, 9)  , Max(11, 11)
    //Min (13, 11) => 11
    private static int minimumTimeRequired( int[] jobs, int k ) {
        if (k == jobs.length) {
            return IntStream.of(jobs).max().getAsInt();
        }

        //work without sorting as well..
        //Arrays.sort(jobs);

        //init with new int[K] workers to calc Max of worker workloads
        dfs(jobs, 0, new int[k], 0);
        return res;
    }

    private static void dfs( int[] jobs, int i, int[] workloads, int preMax ) {
        if (i == jobs.length) {
            //then Min of Options storing as Res..
            res = Math.min(res, preMax);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int w = 0; w < workloads.length; w++) {

            //bcz second worker can't pick same task
            if (!used.add(workloads[w]))
                continue;

            if (workloads[w] + jobs[i] > res)
                continue;

            workloads[w] += jobs[i];

            dfs(jobs, i + 1, workloads, Math.max(workloads[w], preMax));

            //backtrack..
            workloads[w] -= jobs[i];
        }
    }
}
