package com.coding.leetcode.contests.weekely.weekely226;

import java.util.*;

public class RestoreArrFromPairs {

    //https://leetcode.com/contest/weekly-contest-226/problems/restore-the-array-from-adjacent-pairs/
    public static void main( String[] args ) {
        int[][] adjacentPairs = {
                {2, 1},
                {3, 2},
                {3, 4}
        };
        System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
    }

    //Runtime: 137 ms
    //Memory Usage: 81.8 MB
    private static int[] restoreArray( int[][] adjacentPairs ) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //build the graph
        for (int[] pairs : adjacentPairs) {
            buildGraph(pairs[0], pairs[1], graph);
            buildGraph(pairs[1], pairs[0], graph);
        }

        //finding the start; Key having only 1 value is the Start
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        //trying BFS with Graph and Start key now..
        int[] res = new int[adjacentPairs.length + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        //TO track the Visited
        Set<Integer> set = new HashSet<>();
        set.add(start);

        int count = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            res[count++] = num;

            List<Integer> neighbours = graph.get(num);
            for (Integer currNeigh : neighbours) {
                if (set.add(currNeigh)) {
                    q.offer(currNeigh);
                }
            }
        }

        return res;
    }

    private static void buildGraph( int pair0, int pair1, Map<Integer, List<Integer>> graph ) {
        if (graph.containsKey(pair0)) {
            graph.get(pair0).add(pair1);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(pair1);
            graph.put(pair0, list);
        }
    }
}
