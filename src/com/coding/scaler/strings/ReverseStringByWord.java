package com.coding.scaler.strings;

import java.util.Arrays;

public class ReverseStringByWord {

    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));




        String str = "never odd or evep";

        boolean palindrome = isPalindrome(str, 0, str.length() - 1);

        String p = palindrome ? "true" : "false";

        //System.out.println(isPalindrome(str, 0, str.length() - 1));

        System.out.println( WordCount("Never eat shredded wheat or cake"));
    }

    public static String WordCount(String str) {

        String res = str.trim();
        String [] words = res.split(" ");

        // code goes here
        return String.valueOf(words.length);
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

    private static boolean isPalindrome(String str, int i, int j) {
        while(i < str.length() && j >= 0) {
            if(str.charAt(i)== ' ')
                i++;
            if(str.charAt(j)== ' ')
                j--;
            else if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
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
