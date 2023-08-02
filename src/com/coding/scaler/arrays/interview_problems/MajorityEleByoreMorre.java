package com.coding.scaler.arrays.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityEleByoreMorre {

    /**
     * Given an array of size N, find the majority element. The majority element is the element
     * that appears more than floor(n/2) times.
     * You may assume that the array is non-empty and the majority element always exists in the array.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 6, 5));
        System.out.println(majorityElement(list));
    }

    private static int majorityElement(List<Integer> list) {
        int n = list.size();
        int num = 0, count = 0;
        for (int x : list) {
            if (count == 0)
                num = x;

            count += (x == num ? 1 : -1);
        }

        count = 0;
        for (int x : list) {
            if (x == num)
                count++;

            if (count > n / 2)
                return x;
        }

        return -1;
    }
}
