package com.coding.scaler.advance.graph;

public class AdjacentBlackShape {

    /**
     * Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
     *
     * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
     *
     * Input 1:
     *
     *  A = [ [X, X, X], [X, X, X], [X, X, X] ]
     * Input 2:
     *
     *  A = [ [X, O], [O, X] ]
     *
     *
     *  Output 1:
     *
     *  1
     * Output 2:
     *
     *  2
     *
     *
     *  Explanation 1:
     *
     *  All X's belong to single shapes
     * Explanation 2:
     *
     *  Both X's belong to different shapes
     */
    public static void main(String[] args) {
        //String [] A = {"XXX", "XXX" , "XXX"};
        String [] A = {"X0", "0X"};
        System.out.println(black(A));
    }

    private static int black(String[] A) {
        int islands = 0;
        char [][] chars = new char[A.length][A[0].length()];
        for (int i=0; i<A.length; i++) {
            chars[i] = A[i].toCharArray();
        }

        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[i].length(); j++) {
                if(chars[i][j] == 'X') {
                    chars[i][j] = '0';
                    islands++;
                    dfs(chars, i, j);
                }
            }
        }
        return islands;
    }

    private static int xdir[] = { -1, 0, 1, 0 };
    private static int ydir[] = { 0, -1, 0, 1 };
    private static void dfs(char[][] chars, int i, int j) {
        for (int k=0; k<4; k++) {
            int r = i + xdir[k];
            int c = j + ydir[k];

            if(r >= 0 && r < chars.length && c >= 0 && c < chars[0].length && chars[r][c] == 'X') {
                chars[r][c] = '0';
                dfs(chars, r, c);
            }
        }
    }
}
