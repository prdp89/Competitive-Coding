package com.coding.leetcode.contests.weekely.weekely240;

import java.util.Stack;

public class MaxSubArrMinProd {

    //https://leetcode.com/contest/weekly-contest-240/problems/maximum-subarray-min-product/
    public static void main( String[] args ) {
        int[] m = {1, 2, 3, 2};
        System.out.println(maxSumMinProduct(m));
    }

    //42 / 42 test cases passed.
    //Status: Accepted
    //Runtime: 39 ms
    private static int maxSumMinProduct( int[] n ) {
        Stack<Integer> st = new Stack<>();
        long dp[] = new long[n.length + 1], res = 0;

        for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];

        for (int i = 0; i <= n.length; ++i) {

            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();

                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }

            st.push(i);
        }

        return (int) (res % 1000000007);
    }
}
