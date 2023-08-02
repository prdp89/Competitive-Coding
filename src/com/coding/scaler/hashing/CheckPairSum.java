package com.coding.scaler.hashing;

import java.util.HashSet;

public class CheckPairSum {

    /**
     * Given an Array of integers B, and a target sum A.
     * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
     *
     * A = 8
     * B = [3, 5, 1, 2, 1, 2]
     *
     * Output 1:
     * 1
     *
     * Example 1:
     * It is possible to obtain sum 8 using 3 and 5.
     */
    public static void main(String[] args) {
        System.out.println(solve(8, new int[] {3, 5, 1, 2, 1, 2}));
    }

    private static int solve(int A, int[] B) {
        HashSet<Integer> set = new HashSet();

        for (int i : B) {
            if(set.contains( (A - i)))
                return 1;

            set.add(i);
        }

        return 0;
    }
}
