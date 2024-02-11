package com.coding.scaler.advance.maths.combitronics;

public class FindNCRModM {

    /**
     * Given three integers A, B, and C, where A represents n,
     * B represents r, and C represents m, find and return the
     * value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
     *
     * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
     *
     * Input 1:
     *
     *  A = 5
     *  B = 2
     *  C = 13
     *
     *  Output 1:
     *  10
     *
     *  Explanation 1:
     *  The value of 5C2 % 11 is 10.
     */
    public static void main(String[] args) {
        System.out.println(solve(5,2,13));
    }

    /**
     * In the question M is not prime so using combination properties:
     *
     * nCr = N-1 C R-1 + N-1 C R
     *
     * now take modulo both sides:
     *
     * nCr % P = (N-1 C R-1 % P + N-1 C R % P) % P which is equals to:
     *
     * M[i][j] = M[i-1][j-1] + M[i-1] [j]
     *
     */
    private static int solve(int A, int B, int C) {
        int [][] mat = new int[A+1][B+1];

        for(int i=0;i<mat.length; i++) {
            mat[i][0] = 1;
        }

        for(int i=1;i<mat.length; i++) {

            for(int j=1;j<mat[i].length; j++) {
                mat[i][j] = (mat[i-1][j-1] + mat[i-1][j]) % C;
            }
        }

        return mat[A][B];
    }
}
