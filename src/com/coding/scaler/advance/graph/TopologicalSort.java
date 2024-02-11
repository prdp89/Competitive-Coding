package com.coding.scaler.advance.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TopologicalSort {

    /**
     * Given an directed acyclic graph having A nodes. A matrix B of size M x 2
     * is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering
     * of vertices such that for every directed edge uv, vertex u comes before v in the ordering.
     * Topological Sorting for a graph is not possible if the graph is not a DAG.
     *
     * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
     *
     * If there is a solution return the correct ordering. If there are multiple solutions
     * print the lexographically smallest one.
     *
     * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g)
     * if a < e or if(a==e) then b < f and so on.
     *
     * Input 1:
     *
     *  A = 6
     *  B = [  [6, 3]
     *         [6, 1]
     *         [5, 1]
     *         [5, 2]
     *         [3, 4]
     *         [4, 2] ]
     *
     *  Output 1:
     *  [5, 6, 1, 3, 4, 2]
     *
     *  Explanation 1:
     *  The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(6, new int[][]{
                {6, 3},
                {6, 1},
                {5, 1},
                {5, 2},
                {3, 4},
                {4, 2},
        })));
    }

    private static int[] solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int [] inDegree = new int[A+1];
        boolean[] vis = new boolean[A+1];

        for (int i=0; i<=A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i < B.length; i++) {
            graph.get(B[i][0]).add(B[i][1]);
            inDegree[B[i][1]]++;
        }

        //maintain lexicographically smaller list.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=A; i++) {
            //starting from first element indegree
            if(inDegree[i] == 0)
                pq.offer(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            vis[u] = true;
            ans.add(u);

            for (Integer adj: graph.get(u)) {
                if(!vis[adj]) {
                    inDegree[adj]--;

                    if(inDegree[adj] == 0) {
                        pq.offer(adj);
                    }
                }
            }
        }

        int [] arrAns = new int[ans.size()];
        for (int i=0; i< ans.size(); i++) {
            arrAns[i] = ans.get(i);
        }
        return arrAns;
    }
}
