package com.coding.scaler.hashing;

import java.util.HashSet;

public class PairWithGivenDiff {

    /**
     * Given an one-dimensional unsorted array A containing N integers.
     *
     * You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
     *
     * Return 1 if any such pair exists else return 0.
     *
     * Input 1:
     *
     *  A = [5, 10, 3, 2, 50, 80]
     *  B = 78
     *
     *  Output 1:
     *
     *  1
     *
     *  Explanation 1:
     *
     *  Pair (80, 2) gives a difference of 78.
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {5, 10, 3, 2, 50, 80}, 78));
    }

    private static int solve(int[] A, int B) {

        HashSet<Integer> set = new HashSet();

        for(int item: A) {
            int diff = B + item;
            int diff2 = item - B;

            if(set.contains(diff)) {
                return 1;
            }

            if(set.contains(diff2)) {
                return 1;
            }
            set.add(item);
        }

        return 0;
    }

}
