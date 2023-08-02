package com.coding.scaler.strings;

import java.util.Arrays;

public class ReverseStringByWord {

    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));
    }

    //eht yks
    private static String solve(String A) {
        char[] s = A.toCharArray();
        int n = s.length;
        int start = 0, end = 0;

        // reverse the whole string
        reverse(0, s.length - 1, s);

        while (start < n) {
            while (end < n && s[end] != ' ')
                ++end;

            // reverse the word
            reverse( start, end - 1, s);

            // move to the next word
            start = end + 1;
            ++end;
        }

        return String.valueOf(s).trim();
    }

    private static void reverse(int i, int j, char[] arr) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
