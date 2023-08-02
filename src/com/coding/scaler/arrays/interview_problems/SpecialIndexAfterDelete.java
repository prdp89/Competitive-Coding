package com.coding.scaler.arrays.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialIndexAfterDelete {

    /**
     * Given an array, arr[] of size N, the task is to find the count of array indices such that
     * removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     * <p>
     * Input 1:
     * A  =     [2, 1, 6, 4]
     * indexes= [0, 1, 2, 3]
     * <p>
     * del(0) : 0th index deleted: A = [1, 6, 4]
     * indexes = [0, 1, 2]
     * odd indexes ele=[ 6 ]
     * even indexes ele=[ 1, 4 ]
     * their sums are not equal=> 6 != 5 = is bad
     * <p>
     * del(1) : 1st index deleted: A = [2, 6, 4]
     * *                indexes = [0, 1, 2]
     * *                odd indexes ele=[ 6 ]
     * *                even indexes ele=[ 2, 4 ]
     * *                their sums are equal=> 6 == 6  = is good
     * <p>
     * we have to return count of all good indices.
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 6, 4));
        System.out.println(solveBruteForce(list));
    }

    private static int solveBruteForce(List<Integer> list) {
        int count = 0, n = list.size(), flag;

        for (int i = 0; i < n; i++) {
            int[] copyArr = new int[n - 1];
            flag = 0;

            //copy the arr to new array skipping(removing) ith element
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    flag++;
                }
                copyArr[j] = list.get(j + flag);
            }

            int sumOfEvenIndicesElement = 0, sumOfOddIndicesElement = 0;
            for (int j = 0; j < n - 1; j++) {
                if (j % 2 == 0)
                    sumOfEvenIndicesElement += copyArr[j];
                else
                    sumOfOddIndicesElement += copyArr[j];
            }
            if (sumOfEvenIndicesElement == sumOfOddIndicesElement)
                count++;
        }

        return count;
    }

    private static int solveOptimal(List<Integer> list) {
        //Formula:
        //Even index sum = even nums on left side of deleted element + odd nums on right side of deleted element
        //Odd index sum = Odd nums on left side of deleted element + even nums on right side of deleted element

        //logic to calc right side of deleted element:
        //1 2 3 4 5
        //pf = 1 3 6 10 15
        //pf sum on right of 3 => (n-i) => pf(n-1) - pf(3)
        //15 - 6 = 9

        int count = 0, n = list.size();

        int[] pfEven = new int[n];
        pfEven[0] = list.get(0); //bcz zero index is even
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0)
                pfEven[i] = pfEven[i - 1] + list.get(i);
            else
                pfEven[i] = pfEven[i - 1];
        }


        int[] pfOdd = new int[n];
        pfOdd[0] = 0; //bcz zero index is odd
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0)
                pfOdd[i] = pfOdd[i - 1] + list.get(i);
            else
                pfOdd[i] = pfOdd[i - 1];
        }

        int sumOdd = 0, sumEven = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumEven = pfOdd[n - 1] - pfOdd[i];
                sumOdd = pfEven[n - 1] - pfEven[i];
            } else {
                sumEven = pfOdd[n - 1] - pfOdd[i] + pfEven[i - 1];
                sumOdd = pfEven[n - 1] - pfEven[i] + pfOdd[i - 1];
            }

            if (sumEven == sumOdd)
                count++;
        }

        return count;
    }
}
