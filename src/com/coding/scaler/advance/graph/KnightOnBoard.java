package com.coding.scaler.advance.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnBoard {

    /**
     * Given any source point, (C, D) and destination point, (E, F) on
     * a chess board of size A x B, we need to find whether Knight can move to the destination or not.
     *
     * The above figure details the movements for a knight ( 8 possibilities and 2 steps backwards or forwards ).
     *
     * If yes, then what would be the minimum number of steps for the knight to move to the said point.
     * If knight can not move from the source point to the destination point, then return -1.
     *
     * NOTE: A knight cannot go out of the board.
     *
     * Input 1:
     *
     *  A = 8
     *  B = 8
     *  C = 1
     *  D = 1
     *  E = 8
     *  F = 8
     *
     *  Output 1:
     *
     *  6
     *
     *  Explanation 1:
     *
     *  The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
     *  The minimum number of moves required for this is 6.
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(knight(8,8,1,1,8,8));
    }

    private static int knight(int A, int B, int C, int D, int E, int F) {
        boolean [][] visited = new boolean[A][B];

        //2 steps backwards or forwards dirx and diry array.
        int [] dirX = {-1, -2, -2 , -1 , 1 ,2 ,2 ,1};
        int [] dirY = {-2, -1, 1 , 2 , 2, 1 , -1, -2};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {C-1, D-1, 0});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0], y = arr[1], steps = arr[2];

            if(x == E-1 && y == F-1) {
                return steps;
            }

            for (int i=0; i<8; i++) {

                int posX = x + dirX[i], posY = y + dirY[i];
                //posX > 0 && posX <= A : bcz pos starts from 1..N
                if(posX >= 0 && posX < A && posY >= 0 && posY < B && !visited[posX][posY]) {
                    q.offer(new int[] {posX, posY, steps + 1});
                    visited[posX][posY] = true;
                }
            }
        }
        return -1;
    }
}
