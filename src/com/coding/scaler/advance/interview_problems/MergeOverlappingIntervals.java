package com.coding.scaler.advance.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Input 1:
     *
     * [1,3],[2,6],[8,10],[15,18]
     *
     *
     * Output 1:
     * [1,6],[8,10],[15,18]
     *
     * Explanation 1:
     *
     * Merge intervals [1,3] and [2,6] -> [1,6].
     * so, the required answer after merging is [1,6],[8,10],[15,18].
     * No more overlapping intervals present.
     */
    public ArrayList<MergeIntervals.Interval> merge(ArrayList<MergeIntervals.Interval> intervals) {
            intervals.sort((a, b) -> a.start - b.start);
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;

            ArrayList<MergeIntervals.Interval> res = new ArrayList();

            for(int i=1; i<intervals.size(); i++) {
                if(intervals.get(i).start <= end) {
                    end = Math.max(end, intervals.get(i).end);
                } else {
                    res.add(new MergeIntervals.Interval(start, end));
                    start = intervals.get(i).start;
                    end = intervals.get(i).end;
                }
            }

            res.add(new MergeIntervals.Interval(start, end));

            return res;
    }
}
