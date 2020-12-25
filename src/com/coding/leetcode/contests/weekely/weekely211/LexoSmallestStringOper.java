package com.coding.leetcode.contests.weekely.weekely211;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexoSmallestStringOper {

    private static String smallest;

    //https://leetcode.com/contest/weekly-contest-211/problems/lexicographically-smallest-string-after-applying-operations/
    //https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
    public static void main( String[] args ) {
        String s = "5525";
        int a = 9, b = 2;

        System.out.println(findLexSmallestString_BFS(s, a, b));

        System.out.println(findLexSmallestString_DFS(s, a, b));
    }

    private static String findLexSmallestString_BFS( String s, int a, int b ) {
        int n = s.length();
        String smallest = s;

        Queue<String> q = new LinkedList<>();
        q.offer(s);

        Set<String> seen = new HashSet<>(q);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (smallest.compareTo(cur) > 0)
                smallest = cur;

            char[] ca = cur.toCharArray();
            for (int i = 1; i < ca.length; i += 2) // add operation.
                ca[i] = (char) ((ca[i] - '0' + a) % 10 + '0');

            String addA = String.valueOf(ca);

            if (seen.add(addA))
                q.offer(addA);

            String rotate = cur.substring(n - b) + cur.substring(0, n - b); // rotation.

            if (seen.add(rotate))
                q.offer(rotate);
        }

        return smallest;
    }

    private static void dfs( String s, int a, int b, Set<String> seen ) {
        if (seen.add(s)) {
            if (smallest.compareTo(s) > 0) {
                smallest = s;
            }

            char[] ca = s.toCharArray();
            for (int i = 1; i < ca.length; i += 2) {
                ca[i] = (char) ((ca[i] - '0' + a) % 10 + '0');
            }

            dfs(String.valueOf(ca), a, b, seen);
            dfs(s.substring(b) + s.substring(0, b), a, b, seen);
        }
    }

    private static String findLexSmallestString_DFS( String s, int a, int b ) {
        smallest = s;
        dfs(s, a, b, new HashSet<>());
        return smallest;
    }
}
