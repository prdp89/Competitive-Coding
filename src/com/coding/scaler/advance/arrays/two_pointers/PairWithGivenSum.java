package com.coding.scaler.advance.arrays.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairWithGivenSum {

    /**
     * Given an one-dimensional integer array A of size N and an integer K.
     *
     * check if there exists a pair [i j] such that a[i] + a[j] = k and i != j
     *
     *
     */
    public static void main(String[] args) {
        int [] arr = {3,7,8,12,19};
        int k = 15;
        
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));


        System.out.println( solve(arr, k));
    }

    private static boolean solve(int[] A, int K) {
        int p1 = 0, p2 = A.length-1;

        while (p1 <= p2) {
            if(A[p1] + A[p2] == K) {
                return true;
            }

            if(A[p1] + A[p2] > K)
                p2--;

            if(A[p1] + A[p2] < K)
                p1++;
        }

        return false;
    }
}
