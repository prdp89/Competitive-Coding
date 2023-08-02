package com.coding.scaler.arrays.carry_forward;

public class SpecialSubSeqAG {

    /**
     * You have given a string A having Uppercase English letters.
     * <p>
     * You have to find how many times subsequence "AG" is there in the given string.
     * <p>
     * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     *
     * @param args Input 1:
     *             <p>
     *             A = "ABCGAG"
     *             <p>
     *             Output 1:
     *             <p>
     *             3
     */
    public static void main(String[] args) {
        System.out.println(solve("ABCGAG"));
    }

    private static int solve(String str) {
        int n = str.length(), count = 0, ans = 0;
        int mod = (int)1e9 + 7;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'G')
                count++;
            else if (str.charAt(i) == 'A')
                ans = (ans + count) % mod;
        }

        return ans;
    }
}
