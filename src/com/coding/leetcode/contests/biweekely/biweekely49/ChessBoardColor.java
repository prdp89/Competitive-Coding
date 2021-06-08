package com.coding.leetcode.contests.biweekely.biweekely49;

public class ChessBoardColor {

    //https://leetcode.com/contest/biweekly-contest-49/problems/determine-color-of-a-chessboard-square/
    public static void main( String[] args ) {
        System.out.println(squareIsWhite("c7"));
    }

    private static boolean squareIsWhite( String coordinates ) {
        return (coordinates.charAt(0) - 'a' + Character.getNumericValue(coordinates.charAt(1))) % 2 == 0;
    }
}
