package com.coding.leetcode.contests.biweekely.biweekely48;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxScoreNOperations {

    //https://leetcode.com/contest/biweekly-contest-48/problems/maximize-score-after-n-operations/
    public static void main( String[] args ) {
        System.out.println(maxScore(new int[]{3, 4, 6, 8}));
    }

    //This is greedy implementation only passing 67 / 75 test cases passed.
    private static int maxScore( int[] nums ) {
        int ans = 0;
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                int g = gcd(x, y);
                Pair np = new Pair(i, j, g);
                pq.add(np);
            }
        }

        boolean[] visited = new boolean[2 * nums.length];
        int operationNumber = nums.length / 2;

        while (pq.size() > 0 && operationNumber > 0) {
            Pair top = pq.remove();
            if (!visited[top.x] && !visited[top.y]) {
                ans += operationNumber * top.g;
                operationNumber--;
                visited[top.x] = true;
                visited[top.y] = true;
            }
        }

        return ans;
    }

    private static int gcd( int a, int b ) {
        if (a == 0) return b;

        return gcd(b % a, a);
    }

    public static class Pair implements Comparable<Pair> {
        int x; // x: idx of x
        int y; // y: idx of y
        int g;

        Pair( int x, int y, int g ) {
            this.x = x;
            this.y = y;
            this.g = g;
        }

        @Override
        public int compareTo( Pair other ) {
            if (this.g == other.g) return this.x - other.x; //by small X
            return other.g - this.g; //but greater G
        }
    }
}
