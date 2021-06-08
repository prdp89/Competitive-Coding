package com.coding.leetcode.contests.weekely.weekely227;

import java.util.PriorityQueue;

public class MaxScoreRemovingStones {

    //https://leetcode.com/contest/weekly-contest-227/problems/maximum-score-from-removing-stones/
    public static void main( String[] args ) {
        int a = 2, b = 4, c = 6;
        System.out.println(maximumScore(a, b, c));
        System.out.println(maximumScore_Maths(a, b, c));
    }

    //Runtime: 72 ms
    //Memory Usage: 38.4 MB
    private static int maximumScore( int a, int b, int c ) {
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(( x, y ) -> y - x);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        int steps = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = pq.isEmpty() ? 0 : pq.poll();

            if (first == 0 || second == 0)
                break;

            if (--first > 0) {
                pq.offer(first);
            }

            if (--second > 0) {
                pq.offer(second);
            }

            steps++;
        }

        return steps;
    }

    //Runtime: 0 ms
    //Memory Usage: 36 MB
    //https://leetcode.com/problems/maximum-score-from-removing-stones/discuss/1053491/One-line-Python-O(1)
    private static int maximumScore_Maths( int a, int b, int c ) {
        int first = (a + b + c) / 2;
        int second = (a + b + c) - Math.max(c, Math.max(a, b));
        return Math.min(first, second);
    }
}

