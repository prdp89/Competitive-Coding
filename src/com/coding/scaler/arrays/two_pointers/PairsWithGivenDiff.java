package com.coding.scaler.arrays.two_pointers;

import java.util.Arrays;
import java.util.Collections;

public class PairsWithGivenDiff {

    /**
     * Given an one-dimensional integer array A of size N and an integer B.
     *
     * Count all distinct pairs with difference equal to B.
     *
     * Here a pair is defined as an integer pair (x, y), where x and y are both numbers
     * in the array and their absolute difference is B.
     *
     * Input 1:
     *  A = [1, 5, 3, 4, 2]
     *  B = 3
     *
     *  Output 1:
     *  2
     *
     *  Explanation 1:
     *  There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 5, 3, 4, 2}, 3));
    }

    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        int p1 =0, p2 = 1, count = 0, n = A.length;

        while (p1 < n && p2 < n) {
            if(p1 == p2) {
                p2++;
                continue;
            }

            int x = A[p1], y = A[p2];
            if(y-x == B) {
                count++;
                //now removing duplicate pairs
                while (p1 < n && A[p1] == x) p1++;
                while (p2 < n && A[p2] == y) p2++;
            }
            else if(y-x > B) {
                p1++;
            } else {
                p2++;
            }
        }

        return count;

    }
}
