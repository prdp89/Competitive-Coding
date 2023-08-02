package com.coding.scaler.arrays.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfEvenIndices {

    /**
     * ou are given an array A of length N and Q queries given by the 2D array B of size Q*2.
     * Each query consists of two integers B[i][0] and B[i][1].
     * For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
     * <p>
     * <p>
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0,2]
     * [1,4]   ]
     * Output 1:
     * [4, 8]
     * <p>
     * For query 1: [0,2] : even indices elements are {1,3} = [4]
     * For query 2: [1,4] : even indices elements are {3,5} = [8]
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        q.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        q.add(new ArrayList<Integer>(Arrays.asList(1, 4)));

        //sumOfEvenIndices(list, q).forEach(System.out::println);
        sumOfOddIndices(list, q).forEach(System.out::println);
    }

    private static ArrayList<Integer> sumOfEvenIndices(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> Q) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size();

        int[] prefix = new int[list.size()];
        prefix[0] = list.get(0);

        for (int i = 1; i < n; i++) {
            //only maintaining the prefix-sum of even indices
            if (i % 2 == 0) {
                prefix[i] = prefix[i - 1] + list.get(i);
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        for (ArrayList<Integer> query : Q) {
            int start = query.get(0), end = query.get(1);
            if (start == 0)
                res.add(prefix[end]);
            else
                res.add(prefix[end] - prefix[start - 1]);
        }

        return res;
    }

    private static ArrayList<Integer> sumOfOddIndices(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> Q) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = list.size();

        int[] prefix = new int[list.size()];
        prefix[0] = 0;

        for (int i = 1; i < n; i++) {
            //only maintaining the prefix-sum of even indices
            if (i % 2 != 0) {
                prefix[i] = prefix[i - 1] + list.get(i);
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        for (ArrayList<Integer> query : Q) {
            int start = query.get(0), end = query.get(1);
            if (start == 0)
                res.add(prefix[end]);
            else
                res.add(prefix[end] - prefix[start - 1]);
        }

        return res;
    }
}
