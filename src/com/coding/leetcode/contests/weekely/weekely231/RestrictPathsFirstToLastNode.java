package com.coding.leetcode.contests.weekely.weekely231;

import java.util.*;

//https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
public class RestrictPathsFirstToLastNode {

    public static void main( String[] args ) {
        int[][] edges = {
                {1, 2, 3},
                {1, 3, 3},
                {2, 3, 1},
                {1, 4, 2},
                {5, 2, 2},
                {3, 5, 1},
                {5, 4, 10}
        };
        int n = 5;

        System.out.println(countRestrictedPaths(n, edges));
    }

    //https://www.youtube.com/watch?v=-wNfD38uYJU
    //Restricted Paths: If we are calc. distance from Node N to i then distance from Node i -> i+1 should be in decreasing order.

    private static int dfs( int src, int n, List<int[]>[] graph, int[] dist, Integer[] memo ) {
        if (memo[src] != null) return memo[src];

        if (src == n)
            return 1; // Found a path to reach to destination

        int ans = 0;

        for (int[] nei : graph[src]) {
            int w = nei[0], v = nei[1];
            if (dist[src] > dist[v]) // if first node distance greater than second

                //passing V as next scr node to iterate
                //and all the distance in decreasing order only..
                ans = (ans + dfs(v, n, graph, dist, memo)) % 1000000007;
        }

        return memo[src] = ans;
    }

    //First: We find distance from each node  i to node N
    //Second: We do DFS to find decreasing order distance in a graph
    public static int countRestrictedPaths( int n, int[][] edges ) {
        if (n == 1)
            return 0;

        List<int[]>[] graph = new List[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[2], e[1]});
            graph[e[1]].add(new int[]{e[2], e[0]});
        }

        int[] dist = dijkstra(n, graph);
        return dfs(1, n, graph, dist, new Integer[n + 1]);
    }

    // Dijkstra to find shortest distance of paths from node `n` to any other nodes
    private static int[] dijkstra( int n, List<int[]>[] graph ) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        //sort by distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, n});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], u = top[1];

            //that means distance D is already calc. for Node U
            if (d != dist[u])
                continue;

            for (int[] nei : graph[u]) {
                int w = nei[0], v = nei[1];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w; //storing small distance for next Node V
                    minHeap.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist;
    }
}
