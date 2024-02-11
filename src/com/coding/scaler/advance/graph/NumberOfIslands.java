package com.coding.scaler.advance.graph;

public class NumberOfIslands {

    public static void main(String[] args) {
        int [][] A = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(solve(A));
    }

    private static int solve(int[][] A) {
        int [][] visited = new int[A.length][A[0].length];

        int islands = 0;
        for (int i=0; i<A.length; i++) {

            for (int j=0; j<A[i].length; j++) {

                if(A[i][j] == 1) {
                    A[i][j] = 0;

                    if(visited[i][j] == 0) {
                        islands++;
                        dfs(i, j, visited, A);
                    }
                }
            }
        }
        return islands;
    }

    private static int [] dirs = {-1, 0, 1};
    private static void dfs(int i, int j, int[][] visited, int[][] a) {
        visited[i][j] = 1;

        //moving in directions like MaxAreaOfIsland or FloodFill
        for (int dirX : dirs) {

            for (int dirY : dirs) {

                //this direction is 9th one, so invalid
                if (dirX == 0 && dirY == 0) continue;

                if(isValid(i, j, dirX, dirY, a, visited)) {
                    dfs(i+dirX, j+dirY, visited, a);
                }
            }
        }
    }

    private static boolean isValid(int i, int j, int dirX, int dirY, int[][] a, int[][] visited) {
        int n = a.length;    // Number of rows
        int m = a[0].length; // Number of columns
        if(i + dirX >=0 && i + dirX < n && j + dirY >= 0 && j+dirY < m && a[i+dirX][j+dirY] == 1 && visited[i+dirX][j+dirY] == 0) {
            return true;
        }

        return false;
    }
}
