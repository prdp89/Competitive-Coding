package com.coding.scaler.arrays.prefix;

import java.util.ArrayList;
import java.util.Arrays;

public class EvenNumsInRange {

    /**
     * You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
     *
     * Each query consists of two integers B[i][0] and B[i][1].
     *
     * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
     *
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0, 2]
     *         [2, 4]
     *         [1, 4]   ]
     *
     * Output 1:
     * [1, 1, 2]
     *
     * For Input 1:
     * The subarray for the first query is [1, 2, 3] (index 0 to 2) which contains 1 even number.
     * The subarray for the second query is [3, 4, 5] (index 2 to 4) which contains 1 even number.
     * The subarray for the third query is [2, 3, 4, 5] (index 1 to 4) which contains 2 even numbers.
     */
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0,2)));
        B.add(new ArrayList<>(Arrays.asList(2,4)));
        B.add(new ArrayList<>(Arrays.asList(1,4)));

        solve(temp, B).forEach(System.out::println);
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> B) {
        temp.set(0, temp.get(0) % 2 == 0 ? 1 : 0);
        for (int i=1; i<temp.size(); i++) {
            if(temp.get(i)%2 == 0) {
                temp.set(i, temp.get(i-1)+ 1);
            } else
                temp.set(i, temp.get(i-1));
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(ArrayList<Integer> outer: B) {
            int l = outer.get(0), r = outer.get(1);

            if (l == 0)
                res.add(temp.get(r));
            else {
                res.add(temp.get(r) - temp.get(l-1));
            }
        }

        return res;
    }
}
