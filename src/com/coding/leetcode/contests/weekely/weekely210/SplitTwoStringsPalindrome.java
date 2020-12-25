package com.coding.leetcode.contests.weekely.weekely210;

public class SplitTwoStringsPalindrome {

    //https://leetcode.com/contest/weekly-contest-210/problems/split-two-strings-to-make-palindrome/
    public static void main( String[] args ) {
        String a = "ulacfd", b = "jizalu";
        System.out.println(checkPalindromeFormation(a, b));
    }

    //Another way to think about this: using more characters from the both strings "shrinks" the middle part,
    //so it increases the chance that the middle part is a palindrome.
    private static boolean checkPalindromeFormation( String a, String b ) {
        return check(a, b) || check(b, a);
    }

    private static boolean check( String a, String b ) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            ++i;
            --j;
        }

        // a = "ulacfd", b = "jizalu"
        //at this point i = 3 and j = 2 {from backwarrds}
        //Since we reach to middle point and i >= j so we can always form a palindrome.

        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private static boolean isPalindrome( String s, int i, int j ) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }

        return i >= j;
    }
}
