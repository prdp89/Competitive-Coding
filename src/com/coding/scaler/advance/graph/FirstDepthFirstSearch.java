package com.coding.scaler.advance.graph;

import java.util.ArrayList;

public class FirstDepthFirstSearch {

    /**
     * You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
     *
     * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
     *
     * B C : query to find whether B is reachable from C.
     *
     * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
     *
     * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
     *
     * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 1, 2]
     *  B = 1
     *  C = 2
     * Input 2:
     *
     *  A = [1, 1, 2]
     *  B = 2
     *  C = 1
     *
     *  Output 1:
     *
     *  0
     * Output 2:
     *
     *  1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve( new int[] {1,1,2}, 2, 1));
    }

    private static int solve(int[] A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A.length; i++)
            graph.add(new ArrayList<>());

        for (int i=1; i < A.length; i++)
            graph.get(A[i]).add(i+1);

        boolean [] visited = new boolean[A.length+1];
        int start = C;

        dfs(visited, graph, start);

        if(visited[B]) {
            return 1;
        }

        return 0;
    }

    private static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int start) {
        visited[start] = true;

        for (int adj: graph.get(start)) {
            if(!visited[adj]) {
                dfs(visited, graph, adj);
            }
        }
    }
}
