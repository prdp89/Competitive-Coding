package com.coding.scaler.arrays.two_pointers;

import java.util.HashMap;

public class PairWithGivenSumII {

    /**
     * Given a sorted array of integers (not necessarily distinct) A and an integer B,
     * find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
     *
     * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 5, 7, 10}, 8));
    }

    private static int solve(int[] A, int B) {
        int mod = (int)1e9+7, ans = 0, p1 = 0, p2 = A.length-1;

        while (p1 < p2) {
            if(A[p1] + A[p2] == B) {
                if(A[p1] == A[p2]) {
                    //[4, 4,4, 4,  5,6,7,8]
                    // p1      p2
                    //we have 6 pairs bw p2 and p1
                    long cnt = p2 - p1 + 1;
                    ans += (cnt * (cnt - 1) / 2) % mod;
                    ans %= mod;
                    break;
                } else {
                    int p1Duplicate = p1,  p2Duplicate = p2;
                    //count number of element with values A[p1]
                    while (A[p1] == A[p1Duplicate]) {
                        p1Duplicate++;
                    }
                    int p1DuplicateCount = p1Duplicate - p1;
                    //move p1 to last occurrance of it.
                    p1 = p1Duplicate;

                    while (A[p2] == A[p2Duplicate]) {
                        p2Duplicate--;
                    }
                    int p2DuplicateCount = p2 - p2Duplicate;
                    //move p2 to last occurrance of it.
                    p2 = p2Duplicate;

                    ans += (p1DuplicateCount * p2DuplicateCount) % mod;
                    ans %= mod;
                }
            } else if(A[p1] + A[p2] > B) {
                p2--;
            } else p1++;
        }
        return ans;
    }
}
