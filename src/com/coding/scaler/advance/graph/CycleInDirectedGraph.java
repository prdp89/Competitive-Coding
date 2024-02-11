package com.coding.scaler.advance.graph;

import java.util.ArrayList;

public class CycleInDirectedGraph {

    /**
     * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
     *
     * Input 1:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [4, 1]
     *         [2, 4]
     *         [3, 4]
     *         [5, 2]
     *         [1, 3] ]
     *
     *
     * Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     *  The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(5, new int[][]{
                {1,2},
                {4,1},
                {2,4},
                {3,4},
                {5,2},
                {1,3},
        }));
    }

    private static int hasCycle = 0;
    private static int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i < B.length; i++)
            graph.get(B[i][0]).add(B[i][1]);

        int [] visited = new int[A+1];

        //need to visit every node in a graph.
        for(int i=1; i<=A; i++)
        {
            if(visited[i] == 0) {
                dfs(i, graph, visited);
            }

            if(hasCycle == 1)
                return 1;
        }

        return 0;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        visited[node] = 1;

        for (int adj: graph.get(node)) {
            if(visited[adj] == 0) {
                dfs(adj, graph, visited);
            }
            else if(visited[adj] == 1)
                return;
        }

        //to mark as revisited to preserve a state. see notes for more clarity.
        visited[node] = 2;
    }
}
