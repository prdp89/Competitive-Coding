package com.coding.leetcode.contests.monthlycontest.octcontest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class NumberOfRecentCalls {

    //private List<Integer> list;

    Queue<Integer> q;
    TreeMap<Integer, Integer> tm;

    public NumberOfRecentCalls() {
        //  list = new ArrayList<>();
        //list.add(0);

        q = new LinkedList<>();
        tm = new TreeMap<>();
    }

    //https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3480/
    public static void main( String[] args ) {
        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();

        System.out.println(numberOfRecentCalls.ping(1));
        System.out.println(numberOfRecentCalls.ping(100));
        System.out.println(numberOfRecentCalls.ping(3001));
        System.out.println(numberOfRecentCalls.ping(3002));
    }

    /*public int ping( int t ) {
        int start = t - 3000;
        if (start < 0) {
            list.add(list.get(list.size() - 1) + 1);
            return list.get(list.size() - 1);
        } else {
            list.add(list.get(list.size() - 1) + list.get(start));
            return list.get(list.size() - 1);
        }
    }*/

    //using queue O(Log N)
   /* public int ping( int t ) {
        q.offer(t);

        //removing out of range values..
        while (null != q.peek() && q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }*/

    public int ping( int t ) {
        tm.put(t, 1 + tm.size());

        //tail map returns [t - 3000 -- map.size()]
        return tm.tailMap(t - 3000).size();
    }
}
