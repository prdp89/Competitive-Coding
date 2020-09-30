package com.coding.leetcode.graph;

import java.util.*;

public class EvaluateDivision {

    //https://leetcode.com/problems/evaluate-division/
    public static void main( String[] args ) {
        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        List<List<String>> equations = new ArrayList<>();

        List<String> list1 = Arrays.asList("a", "b");
        equations.add(list1);

        List<String> list2 = Arrays.asList("b", "c");
        equations.add(list2);

        List<String> q1 = Arrays.asList("a", "c");
        queries.add(q1);
        List<String> q2 = Arrays.asList("b", "a");
        queries.add(q2);
        List<String> q3 = Arrays.asList("a", "e");
        queries.add(q3);
        List<String> q4 = Arrays.asList("x", "x");
        queries.add(q4);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    /*
    Time Complexity - O(Q * (V + E)), where Q - Queries, V - Number of Vertices, E - Number Edges (length of values).
    Space Complexity - O(V + E).
     */
    //Runtime: 1 ms, faster than 71.85% of Java
    private static double[] calcEquation( List<List<String>> equations, double[] values, List<List<String>> queries ) {
        Map<String, List<Pair>> graph = buildGraph(equations, values);

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0),
                    queries.get(i).get(1),
                    new HashSet<>(),
                    graph);
        }

        return res;
    }

    private static Map<String, List<Pair>> buildGraph( List<List<String>> eq, double[] values ) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = eq.get(i).get(0);
            String dest = eq.get(i).get(1);

            map.putIfAbsent(src, new ArrayList<>());
            map.putIfAbsent(dest, new ArrayList<>());

            //creating bi-directional path src --> des --> values[i]
            //                             dest --> src --> 1/ values[i]
            //bcz if a/b = 2 then b/a = 1/2
            map.get(src).add(new Pair(dest, values[i]));
            map.get(dest).add(new Pair(src, 1 / values[i]));
        }

        return map;
    }

    private static double dfs( String src, String dest, Set<String> visited, Map<String, List<Pair>> graph ) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            return -1.0;
        }

        if (src.equals(dest)) {
            return 1.0;
        }

        visited.add(src);
        for (Pair curNode : graph.get(src)) {
            if (!visited.contains(curNode.node)) {
                double ans = dfs(curNode.node, dest, visited, graph);
                if (ans != -1.0)
                    return ans * curNode.cost;
            }
        }

        return -1.0;
    }

    private static class Pair {
        double cost;
        String node;

        Pair( String node, double cost ) {
            this.node = node;
            this.cost = cost;
        }
    }
}
