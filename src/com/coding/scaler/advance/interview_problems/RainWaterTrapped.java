package com.coding.scaler.advance.interview_problems;

public class RainWaterTrapped {

    /**
     * Given a vector A of non-negative integers representing an elevation map where
     * the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     * A = [0, 1, 0, 2]
     * Output 1:
     * 1
     *
     * Explanation 1:
     * 1 unit is trapped on top of the 3rd element.
     */
    public static void main(String[] args) {
        System.out.println(trap(new int[] {
                0, 1, 0, 2
        }));
    }

    //formula: min(lmax - rmax)-h[i]
    private static int trap(final int[] A) {
        int [] lmax = new int[A.length];
        int [] rmax = new int[A.length];

        lmax[0] = A[0];
        for(int i=1; i<A.length; i++) {
            lmax[i] = Math.max(lmax[i-1], A[i]);
        }

        rmax[A.length-1] = A[A.length-1];
        for(int i=A.length-2; i>=0; i--) {
            rmax[i] = Math.max(rmax[i+1], A[i]);
        }

        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum = sum + Math.min(lmax[i], rmax[i]) - A[i];
        }

        return sum;
    }
}
