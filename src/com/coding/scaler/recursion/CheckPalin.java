package com.coding.scaler.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CheckPalin {

    public static void main(String[] args) {
        System.out.println( solve("AAA"));

        System.out.println();

    }

    public static int solve(String A) {
        int n = A.length();
        if(isPalin(A, 0, n-1)) {
            return 1;
        }
        return 0;
    }

    public static boolean isPalin(String A, int i, int j) {
        if(i>=j)
            return true;

        if(A.charAt(i) == A.charAt(j)) {
            return isPalin(A, i+1, j-1);
        }

        return false;
    }

}
