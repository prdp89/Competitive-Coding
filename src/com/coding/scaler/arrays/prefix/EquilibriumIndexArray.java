package com.coding.scaler.arrays.prefix;

import java.util.ArrayList;
import java.util.Arrays;

public class EquilibriumIndexArray {

    /**
     * You are given an array A of integers of size N.
     *
     * Your task is to find the equilibrium index of the given array
     *
     * The equilibrium index of an array is an index such that the sum of elements
     * at lower indexes is equal to the sum of elements at higher indexes.
     *
     * If there are no elements that are at lower indexes or at higher indexes,
     * then the corresponding sum of elements is considered as 0.
     *
     * Note:
     *
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     *
     * Input 1:
     * A = [-7, 1, 5, 2, -4, 3, 0]
     *
     * Output 1:
     * 3
     *
     * Explanation 1:
     * i   Sum of elements at lower indexes    Sum of elements at higher indexes
     * 0                   0                                   7
     * 1                  -7                                   6
     * 2                  -6                                   1
     * 3                  -1                                  -1
     * 4                   1                                   3
     * 5                  -3                                   0
     * 6                   0                                   0
     *
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-7, 1, 5, 2, -4, 3, 0));
        System.out.println(solve(list));
    }


    private static int solve(ArrayList<Integer> temp) {
        int n = temp.size();
        for (int i=1; i<n; i++) {
            temp.set(i, temp.get(i-1) + temp.get(i));
        }

        for(int i=0; i<n; i++) {
            int lSum = 0, rSum = 0;
            if(i > 0) {
                lSum = temp.get(i-1);
            }
            rSum = temp.get(n-1) - temp.get(i);

            if(lSum == rSum)
                return i;
        }

        return -1;
    }
}
