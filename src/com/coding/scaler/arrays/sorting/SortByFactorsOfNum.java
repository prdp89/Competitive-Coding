package com.coding.scaler.arrays.sorting;

import java.util.Arrays;
import java.util.List;

public class SortByFactorsOfNum {

    /**
     * You are given an array A of N elements. Sort the given array in increasing order
     * of number of distinct factors of each element,
     * <p>
     * i.e., element having the least number
     * of factors should be the first to be displayed and the number having highest number
     * of factors should be the last one.
     * <p>
     * If 2 elements have same number of factors, then number
     * with less value should come first.
     * <p>
     * A = [6, 8, 9]
     * <p>
     * Output :
     * [9, 6, 8]
     * <p>
     * The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
     */
    public static void main(String[] args) {
        for (int i : solve(new int[]{6, 8, 9})) {
            //System.out.println(i);
        }

        for (int i : solveTensDigit(new int[]{15, 11, 7, 19})) {
            System.out.println(i);
        }
    }

    private static int[] solve(int[] A) {

        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++)
            arr[i] = A[i];

        Arrays.sort(arr, (x, y) -> {
            int f1 = factors(x);
            int f2 = factors(y);
            return f1 == f2 ? x - y : f1 - f2;
        });

        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i++)
            temp[i] = arr[i];

        return temp;
    }

    /**
     * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
     *
     * If a number has no tens digit, we can assume value to be 0.
     * If 2 numbers have same tens digit, in that case number with max value will come first
     * Solution should be based on comparator.
     */
    private static int[] solveTensDigit(int[] A) {

        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++)
            arr[i] = A[i];

        Arrays.sort(arr, (x, y) -> {
            int c = (x / 10) % 10;
            int d = (y / 10) % 10;

            return c == d ? y - x : c - d;
        });

        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i++)
            temp[i] = arr[i];

        return temp;
    }

    private static int factors(int n) {
        int count = 0, sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i != n / i)
                    count += 2;
                else
                    count += 1;
            }
        }

        return count;
    }
}
