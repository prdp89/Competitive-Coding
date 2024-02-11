package com.coding.scaler.advance.dp.strings;

import java.util.Arrays;

public class DistinctSubseq {

    /**
     * Input 2:
     *
     *  A = "rabbbit"
     *  B = "rabbit"
     *
     *  Output 2:
     *
     *  3
     *
     *
     *  Explanation 2:
     *
     *  These are the possible removals of characters:
     *     => A = "ra_bbit"
     *     => A = "rab_bit"
     *     => A = "rabb_it"
     *
     *  Note: "_" marks the removed character.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( numDistinct("rabbbit", "rabbit"));
    }

    private static int numDistinct(String A, String B) {
        int n=A.length();
        int m=B.length();
        int dp[][]=new int[m+1][n+1];

        for(int j=0;j<n;j++)
        {
            dp[0][j]=1;
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(A.charAt(j-1)==B.charAt(i-1))
                {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    static int[][] dp = null;

    public int numDistinct_topdown(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(s, t, 0, 0);
    }

    private static int helper( String s, String t, int i, int j ) {
        if (j >= t.length()) return 1; //if second string reaches length then atleast one match

        if (i >= s.length()) return 0; //first string is greater if this reaches length then no matches

        if (dp[i][j] != -1) return dp[i][j];

        int sol = helper(s, t, i + 1, j); //try searching/including next char of first string

        if (s.charAt(i) == t.charAt(j))
            sol += helper(s, t, i + 1, j + 1); //if char matches then increment index and look for next pattern

        dp[i][j] = sol;

        return sol;
    }
}
