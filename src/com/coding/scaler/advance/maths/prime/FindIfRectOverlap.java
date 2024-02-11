package com.coding.scaler.advance.maths.prime;

public class FindIfRectOverlap {

    /**
     * Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
     *
     * For the First rectangle,
     * Bottom left corner is (A, B)
     * Top right corner is (C, D)
     * For the Second rectangle,
     * Bottom left corner is (E, F)
     * Top right corner is (G, H).
     * Find and return whether the two rectangles overlap or not.
     *
     * Return 1 if the two rectangles overlap else, return 0.
     *
     *
     * Input 1:
     *
     * A = 0   B = 0
     * C = 4   D = 4
     * E = 2   F = 2
     * G = 6   H = 6
     *
     * Output 1:
     * 1
     *
     */
    public static void main(String[] args) {
        System.out.println(solve(0,0,4,4,2,2,6,6));
    }

    private static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(A>=G || B>=H || C<=E || D<=F)
            return 0;
        else
            return 1;
    }
}
