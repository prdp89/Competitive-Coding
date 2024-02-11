package com.coding.scaler.hashing.advance;

import java.util.HashSet;

public class CountSubArrays {

    /**
     * Misha likes finding all Subarrays of an Array. Now she gives you an array
     * A of N elements and told you to find the number of subarrays of A, that have unique elements.
     *
     * Since the number of subarrays could be large, return value % 109 +7.
     *
     * Input 1:
     *  A = [1, 1, 3]
     *
     *  Output 1:
     *  4
     *
     *  Explanation 1:
     *  Subarrays of A that have unique elements only:
     *  [1], [1], [1, 3], [3]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 1, 3}));
    }

    private static int solve(int[] A) {
        int MOD = (int) 1e9 + 7;
        int n = A.length;
        long count = 0;

        int i=0, j=0;
        HashSet<Integer> set = new HashSet<>();
        while (i<n && j <n) {
            if(!set.contains(A[j])) {
                set.add(A[j]);
                j++;

                count += j - i;
                count %= MOD;
            } else {
                set.remove(A[i]);
                i++;
            }
        }

        return (int) count;
    }
}
