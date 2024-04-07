package com.coding.scaler.advance.greedy;

import java.util.ArrayList;

public class MaxJobsFinish {

    /**
     * There are N jobs to be done, but you can do only one job at a time.
     *
     * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
     *
     * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
     *
     * Return the maximum number of jobs you can finish.
     *
     * Input 1:
     *
     *  A = [1, 5, 7, 1]
     *  B = [7, 8, 8, 8]
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  We can finish the job in the period of time: (1, 7) and (7, 8).
     * @param args
     */
    public static void main(String[] args) {
        int [] a = {1, 5, 7, 1};
        int [] b = {7, 8, 8, 8};

        System.out.println(solve(a, b));
    }

    private static class Pair {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int solve(int[] A, int[] B) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i=0; i<A.length; i++) {
            list.add(new Pair(A[i], B[i]));
        }

        list.sort((a,b)-> a.end - b.end);

        int ans = 1, endLastJob = list.get(0).end;
        for (int i=1; i<list.size(); i++) {
            if(list.get(i).start >= endLastJob) {
                ans++;
                endLastJob = list.get(i).end;
            }
        }

        return ans;
    }
}
