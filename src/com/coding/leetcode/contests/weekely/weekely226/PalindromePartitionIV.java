package com.coding.leetcode.contests.weekely.weekely226;

public class PalindromePartitionIV {

    //https://leetcode.com/problems/palindrome-partitioning-iv/
    //extension of: https://leetcode.com/problems/palindrome-partitioning-ii/
    public static void main( String[] args ) {
        String str = "abcbdd";
        System.out.println(checkPartitioning(str));
    }

    /*
    To cut a cake in 3 pieces, we need 2 cuts. Hence, if we can pick 2 indices (p, s) in the array,
    we can cut the string in 3 parts. This would look like :

    str[0...p] + str[p + 1, ... s - 1] + str[s, ... n - 1]
    For the constraints, notice that :

    The first part is non-empty, implying that p >= 0
    The second part is non-empty, implying that p + 1 <= s - 1
    The third part is non-empty, implying that s <= n - 1
     */

    //Runtime: 164 ms, faster than 35.18% of Java
    private static boolean checkPartitioning( String str ) {
        int n = str.length();
        char[] A = str.toCharArray();

        boolean[][] dp = new boolean[n][n];

        /* dp[i][j] is true if str[i...j] is palindrome */
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                int len = j - i + 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (A[i] == A[j]);
                } else {
                    dp[i][j] = (A[i] == A[j]) && (dp[i + 1][j - 1]);
                }
            }
        }

        for (int p = 0; p < n; p++) {
            for (int s = p + 2; s < n; s++) {
                boolean left = dp[0][p];
                boolean mid = dp[p + 1][s - 1];
                boolean right = dp[s][n - 1];

                if (left && mid && right) {
                    return true;
                }
            }
        }

        return false;
    }
}
