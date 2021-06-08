package com.coding.leetcode.contests.weekely.weekely228;

public class MinDegreeConnectTrio {

    //https://leetcode.com/contest/weekly-contest-228/problems/minimum-degree-of-a-connected-trio-in-a-graph/
    public static void main( String[] args ) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {3, 2},
                {4, 1},
                {5, 2},
                {3, 6}
        };

        System.out.println(minTrioDegree(6, edges));
    }

    private static int minTrioDegree( int n, int[][] edges ) {
        int[] deg = new int[403];
        boolean[][] adj = new boolean[403][403];

        for (int[] vec : edges) {
            int u = vec[0], v = vec[1];

            deg[u]++;
            deg[v]++;
            adj[u][v] = adj[v][u] = true;
        }

        int ans = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!adj[i][j]) continue;

                for (int k = j + 1; k <= n; k++) {
                    if (adj[i][k] && adj[j][k]) {
                        ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6); //each node can have at-// most 2 degrees
                    }
                }
            }
        }

        if (ans == 1e9)
            return -1;

        return ans;
    }
}
