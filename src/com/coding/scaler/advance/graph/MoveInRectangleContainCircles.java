package com.coding.scaler.advance.graph;

public class MoveInRectangleContainCircles {

    /**
     * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
     *
     * There are N circles such that their centers are inside the rectangle.
     *
     * Radius of each circle is R. Now we need to find out if it is possible that we
     * can move from (0, 0) to (x, y) without touching any circle.
     *
     * Note : We can move from any cell to any of its 8 adjecent neighbours and we
     * cannot move outside the boundary of the rectangle at any point of time.
     *
     * Input Format:
     * 1st argument given is an Integer x , denoted by A in input.
     *
     * 2nd argument given is an Integer y, denoted by B in input.
     *
     * 3rd argument given is an Integer N, number of circles, denoted by C in input.
     *
     * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
     *
     * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
     *
     * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
     *
     * Output Format
     * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
     *
     * Input 1:
     *
     *  x = 2
     *  y = 3
     *  N = 1
     *  R = 1
     *  A = [2]
     *  B = [3]
     *
     *  Output 1:
     *
     *  NO
     */

    //https://www.geeksforgeeks.org/path-rectangle-containing-circles/
    public static void main(String[] args) {
        System.out.println(solve(
            3,3,0,  1, new int[]{0}, new int[]{3}
        ));
    }

    private static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] matrix=new int[A+1][B+1];
        for(int i=0;i<A+1;i++){

            for(int j=0;j<B+1;j++){

                //looping for each circle radius with Rectangle[i][j] so that each Rectangle cell can be verified
                for(int k=0;k<C;k++){

                    //using Pythgorean theorem to find out each cell is within the D radius
                    if(Math.sqrt((E[k]-i)*(E[k]-i)+(F[k]-j)*(F[k]-j))<=D){
                        matrix[i][j]=1;
                    }
                }
            }
        }

        //if start or end cell is blocked
        if(matrix[0][0]==1 || matrix[A][B]==1){
            return "NO";
        }

        dfs(0,0,matrix);
        if(matrix[A][B]==1){
            return "YES";
        } else {
            return "NO";
        }
    }

    private static void dfs(int i,int j, int[][] matrix){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]==1){
            return;
        }
        //matrix[i][j]=1 : mark as visited or invalid path
        matrix[i][j]=1;
        dfs(i-1,j,matrix);
        dfs(i-1,j-1,matrix);
        dfs(i-1,j+1,matrix);
        dfs(i,j-1,matrix);
        dfs(i,j+1,matrix);
        dfs(i+1,j,matrix);
        dfs(i+1,j-1,matrix);
        dfs(i+1,j+1,matrix);
    }
}
