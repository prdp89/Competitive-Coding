package com.coding.leetcode.contests.monthlycontest.marcontest;

public class SingleRowKeyboard {

    /*
    There is a special keyboard with all keys in a single row.

    You have given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i – j|.

    You want to type a string word. Write a program to calculate how much time it takes to type it with one finger.
     */

    /*
    Input :- Keyboard = "abcdefghijklmnopqrstuvwxyz", Word = "cba"
    Output :- 4
     */
    public static void main( String[] args ) {
        String key = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        System.out.println(calculateTime(key, word));
    }

    private static int calculateTime( String keyboard, String word ) {
        char[] chars = keyboard.toCharArray();
        int[] countArray = new int[26];

        for (int i = 0; i < countArray.length; i++) {
            countArray[chars[i] - 'a'] = i;
        }

        int result = 0, position = 0;
        char[] charsWord = word.toCharArray();

        for (int i = 0; i < charsWord.length; i++) {
            result = result + Math.abs(countArray[charsWord[i] - 'a'] - position);
            position = countArray[charsWord[i] - 'a'];
        }

        return result;
    }
}
