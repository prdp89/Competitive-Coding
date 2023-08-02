package com.coding.scaler.advance.interview_problems;

import java.util.ArrayList;

public class MergeIntervals {

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     * @param args
     */
    public static void main(String[] args) {

    }

    static class Interval {

        int start;
        int end;

        Interval() {
        }

        Interval( int start, int end ) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "->" + end;
        }
    }

    /**
     * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
     *
     * Output 1:
     *  [ [1, 5], [6, 9] ]
     */
    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();

        for(int i=0; i<intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(newInterval.start > curr.end){
                ans.add(curr);
            } else if(curr.start > newInterval.end){

                ans.add(newInterval);
                for(int j=i; j<intervals.size(); j++){
                    ans.add(intervals.get(j));
                }
                return ans;

            }
            else{
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
        ans.add(newInterval);
        return ans;
    }
}
