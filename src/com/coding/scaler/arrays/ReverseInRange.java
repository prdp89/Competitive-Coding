package com.coding.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseInRange {

    /**
     * Given an array A of N integers. Also given are two integers B and C. Reverse the array A in the given range [B, C]
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        solveBruteForce(list, 2, 3).forEach(System.out::println);
    }

    private static ArrayList<Integer> solveBruteForce(List<Integer> list, int B, int C) {
        int size = list.size();
        for (int i = B; i < C; i++) {
            int temp = list.get(i);
            list.set(i, list.get(C));
            list.set(C, temp);
            C-=1;
        }
        return new ArrayList(list);
    }
}
