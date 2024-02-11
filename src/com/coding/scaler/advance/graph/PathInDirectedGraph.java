package com.coding.scaler.advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {

    /**
     * Given an directed graph having A nodes labelled from 1 to A containing M edges
     * given by matrix B of size M x 2such that there is a edge directed from node
     *
     * B[i][0] to node B[i][1].
     *
     * Find whether a path exists from node 1 to node A.
     *
     * Return 1 if path exists else return 0.
     *
     * NOTE:
     *
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     *
     * Input 2:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [2, 3]
     *         [3, 4]
     *         [4, 5] ]
     *
     * Output 2:
     *
     *  1
     *
     *
     *  Explanation 2:
     *
     *  Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve_bfs(5, new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        }));

        System.out.println(solve_dfs(5, new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        }));
    }

    private static int solve_bfs(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i < B.length; i++)
            graph.get(B[i][0]).add(B[i][1]);


        boolean [] visited = new boolean[A+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        visited[1] = true;
        while (q.size() > 0) {
            int node = q.poll();
            if(node == A)
                return 1;

            for (int adj: graph.get(node)) {
                if(!visited[adj]) {
                    q.offer(adj);
                    visited[adj] = true;
                }
            }
        }

        return 0;
    }

    private static int solve_dfs(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i < B.length; i++)
            graph.get(B[i][0]).add(B[i][1]);


        boolean [] visited = new boolean[A+1];

        return dfs(1, graph, visited, A);
    }

    private static int dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int target) {
        visited[node] = true;

        for (int adj: graph.get(node)) {

            if(adj == target)
                return 1;

            if(!visited[adj]) {
                if(dfs(adj, graph, visited, target) == 1)
                    return 1;
            }
        }
        return 0;
    }
}
