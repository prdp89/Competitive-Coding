package com.coding.scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumberInWindow {

    /**
     * You are given an array of N integers, A1, A2 ,..., AN and an integer B.
     * Return the of count of distinct numbers in all windows of size B.
     *
     * Formally, return an array of size N-B+1 where i'th element in this array
     *
     * Input 1:
     *
     *  A = [1, 2, 1, 3, 4, 3]
     *  B = 3
     *
     *  Output 1:
     *  [2, 3, 3, 2]
     *
     *  Explanation 1:
     *  A=[1, 2, 1, 3, 4, 3] and B = 3
     *  All windows of size B are
     *  [1, 2, 1]
     *  [2, 1, 3]
     *  [1, 3, 4]
     *  [3, 4, 3]
     *  So, we return an array [2, 3, 3, 2].
     */
    public static void main(String[] args) {
        System.out.println( Arrays.toString(solve(new int[] {1, 2, 1, 3, 4, 3}, 3)));
    }

    //https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
    private static int[] solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap();
        int [] res = new int[A.length - B + 1];

        for(int i=0; i<B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int start = 0, end = B;
        res[start++] = map.size();


        for(int i=B; i<A.length; i++) {

            if(map.get(A[i-B]) == 1)
                map.remove(A[i-B]);
            else
                map.put(A[i-B], map.get(A[i-B]) - 1);

            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            res[start++] = map.size();
        }

        return res;

    }
}
