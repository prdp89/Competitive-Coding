package com.coding.scaler.advance.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestDistanceUndirected {

    /**
     * Given a weighted undirected graph having A nodes, a source node C and destination node D.
     *
     * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
     *
     * You are expected to do it in Time Complexity of O(A + M).
     *
     * The first argument given is an integer A, representing the number of nodes.
     *
     * The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
     *
     * The third argument given is an integer C, representing the source node.
     *
     * The fourth argument is an integer D, representing the destination node.
     *
     * Note: B[i][2] will be either 1 or 2.
     *
     *
     * Input 1:
     *
     *
     * A = 6
     * B = [   [2, 5, 1]
     *         [1, 3, 1]
     *         [0, 5, 2]
     *         [0, 2, 2]
     *         [1, 4, 1]
     *         [0, 1, 1] ]
     * C = 3
     * D = 2
     *
     * Output 1:
     *
     *  4
     *
     *  Explanation 1:
     *
     * The path to be followed will be:
     *     3 -> 1 (Edge weight : 1)
     *     1 -> 0 (Edge weight : 1)
     *     0 -> 2 (Edge weight : 2)
     * Total length of path = 1 + 1 + 2 = 4.
     * @param args
     */
    public static void main(String[] args) {
        int A = 6;
        int [][] B = {
                {2, 5, 1},
                {1, 3, 1},
                {0, 5, 2},
                {0, 2, 2},
                {1, 4, 1},
                {0, 1, 1}
        };
        int C = 3, D = 2;
        System.out.println(solve(A, B, C, D));
    }

    static class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            node = n;
            weight = w;
        }
    }

    private static int solve(int A, int[][] B, int C, int D) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i=0; i<=A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            int weight = B[i][2];

            graph.get(src).add(new Pair(dest, weight));
            graph.get(dest).add(new Pair(src, weight));
        }

        int [] distance = new int[A+1];
        Arrays.fill(distance, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(C, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            if(distance[node] == -1) {
                distance[node] = weight;
            }

            for (Pair adj: graph.get(node)) {
                if(distance[adj.node] == -1) {
                    pq.add(new Pair(adj.node, weight + adj.weight));
                }
            }
        }

        return distance[D];
    }
}
