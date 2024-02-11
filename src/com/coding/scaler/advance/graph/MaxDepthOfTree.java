package com.coding.scaler.advance.graph;

import java.util.ArrayList;

public class MaxDepthOfTree {

    /**
     * Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
     *
     * The goal of the problem is to find largest distance between two nodes in a tree.
     * Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path
     * between any pair of nodes since it is a tree).
     *
     * The nodes will be numbered 0 through N - 1.
     *
     * The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N).
     * Exactly one of the i's will have A[i] equal to -1, it will be root node.
     *
     * Input 1:
     *
     *
     * A = [-1, 0]
     * Input 2:
     *
     *
     * A = [-1, 0, 0]
     *
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  Path is 0 -> 1.
     * Explanation 2:
     *
     *  Path is 1 -> 0 -> 2.
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {-1,0,0}));
    }

    private static  int ans = 0;
    private static int solve(int[] A) {
        ans = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A.length; i++)
            graph.add(new ArrayList<>());

        int root = Integer.MAX_VALUE;
        for (int i=0; i<A.length; i++) {
            if(A[i] != -1) {
                graph.get(i).add(A[i]);
                graph.get(A[i]).add(i);
            } else {
                root = i;
            }
        }

        boolean [] visited = new boolean[A.length+1];
        dfs(root, visited, graph);
        return ans;
    }

    private static int dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;

        int maxDepth = 0;
        for (int adj : graph.get(node)) {
            if(!visited[adj]) {
               int depth = dfs(adj, visited, graph) + 1;
                //similar to diameter of Tree
                ans = Math.max(ans, maxDepth+depth);
               maxDepth = Math.max(maxDepth, depth);
            }
        }
        return maxDepth;
    }
}
