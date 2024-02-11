package com.coding.scaler.arrays.two_pointers;

import java.util.Arrays;

public class SubArrayGivenSum {

    /**
     * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     *
     * If the answer does not exist return an array with a single integer "-1".
     *
     * First sub-array means the sub-array for which starting index in minimum.
     *
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5]
     *  B = 5
     *
     *  Output 1:
     *
     *  [2, 3]
     *
     *  Explanation 1:
     *
     *  [2, 3] sums up to 5.
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {5,10,20,100,105}, 110)));
    }

    private static int[] solve(int[] A, int B) {
        int [] pf = new int[A.length];
        pf[0] = A[0];

        for (int i=1; i<A.length; i++) {
            pf[i] = pf[i-1] + A[i];

            //return entire array starts from 0--ith index
            if(pf[i] == B) {
                int [] op = new int[i+1];
                for (int j=0; j<=i; j++) {
                    op[j] = A[j];
                }
                return op;
            }
        }

        //we now have pf array prepared, let search the subarray inside
        return pairDiff(A, pf, B);
    }

    private static int[] pairDiff(int[] A, int[] pf, int B) {
        int n = A.length;
        int p1 = 0, p2 = 1, count = 0;
        while (p1 < n && p2 < n) {
            if(pf[p2] - pf[p1] == B) {
                int [] op = new int[p2-p1];
                for (int i=p1+1,j=0; i<=p2; i++,j++) {
                    op[j] = A[i];
                }
                return op;
            }
            if(pf[p2] - pf[p1]  < B)
                p2++;
            else if(pf[p2] - pf[p1]  > B)
                p1++;
        }

        int [] op = new int[1];
        op[0] = -1;
        return op;
    }
}
