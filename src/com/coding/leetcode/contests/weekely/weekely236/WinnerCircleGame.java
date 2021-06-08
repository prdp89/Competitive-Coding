package com.coding.leetcode.contests.weekely.weekely236;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerCircleGame {

    //https://leetcode.com/contest/weekly-contest-236/problems/find-the-winner-of-the-circular-game/
    public static void main( String[] args ) {
        int n = 6, k = 5;
        System.out.println(findTheWinner(n, k));
    }

    //95 / 95 test cases passed.
    //Status: Accepted
    //Runtime: 35 ms
    private static int findTheWinner( int n, int k ) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            int navigatePeople = k;
            while (navigatePeople-- > 1) {
                q.offer(q.poll());
            }
            //removing the kth element
            q.poll();
        }

        return q.poll();
    }
}
