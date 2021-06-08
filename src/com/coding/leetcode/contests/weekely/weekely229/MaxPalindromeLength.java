package com.coding.leetcode.contests.weekely.weekely229;

public class MaxPalindromeLength {

    Integer[][] dp;

    //https://leetcode.com/contest/weekly-contest-229/problems/maximize-palindrome-length-from-subsequences/
    public static void main( String[] args ) {
        String str = "cacb", str1 = "cbba";
        MaxPalindromeLength max = new MaxPalindromeLength();
        System.out.println(max.longestPalindrome_Bottom_UP(str, str1));
        System.out.println(max.longestPalindrome_Top_Down(str, str1));
    }

    public int longestPalindrome_Bottom_UP( String word1, String word2 ) {
        String word = word1 + word2;
        int n = word.length(), ans = 0;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (i == j) {
                    dp[i][j] = 1;
                } else if (word.charAt(i) == word.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length()) { // Check if this palindrome begins with word1[i] and ends with word2[j]
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
    }

    //Runtime: 177 ms, faster than 13.33% of Java
    public int longestPalindrome_Top_Down( String s, String t ) {
        int m = s.length(), n = t.length(), l = m + n, res = 0;
        dp = new Integer[l][l];

        char[] cs = (s + t).toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    res = Math.max(res, dfs(cs, i, m + j));
                }
            }
        }
        return res;
    }

    private int dfs( char[] cs, int i, int j ) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];
        if (cs[i] == cs[j])
            return dp[i][j] = 2 + dfs(cs, i + 1, j - 1);

        int pickLeft = dfs(cs, i + 1, j);
        int pickRight = dfs(cs, i, j - 1);
        return dp[i][j] = Math.max(pickLeft, pickRight);
    }
}
