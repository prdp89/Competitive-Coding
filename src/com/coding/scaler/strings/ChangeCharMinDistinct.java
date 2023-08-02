package com.coding.scaler.strings;

import java.util.Arrays;

public class ChangeCharMinDistinct {

    /**
     * You are given a string A of size N consisting of lowercase alphabets.
     *
     * You can change at most B characters in the given string to any other lowercase
     * alphabet such that the number of distinct characters in the string is minimized.
     *
     * Find the minimum number of distinct characters in the resulting string.
     *
     * Example Input
     * A = "abcabbccd"
     * B = 3
     *
     * Example Output
     * 2
     *
     *
     * Example Explanation
     * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
     * So the minimum number of distinct character will be 2.
     */
    public static void main(String[] args) {
        System.out.println(solve("abcabbccd", 3));
    }

    private static int solve(String A, int B) {
        int n = A.length();

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            int x = ch - 97;
            arr[x]++;
        }

        Arrays.sort(arr);
        int s = 0;

        for (int i = 0; i < 26; i++) {
            //we update our sum. If sum < B, we move our index to the next element.
            if (arr[i] != 0) {
                s += arr[i];
                if (s > B) {
                    return (25 - i + 1);
                }
            }
        }
        return 1; // just for the sake of syntax.
    }
}
