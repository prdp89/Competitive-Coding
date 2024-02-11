package com.coding.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateBTimesToRight {

    /**
     * Given an integer array A of size N and an integer B, you have to return the same
     * array after rotating it B times towards the right.
     *
     * Input 1:
     *
     * A = [1, 2, 3, 4]
     * B = 2
     *
     * Output 1:
     * [3, 4, 1, 2]
     *
     * @param args
     */
    public static void main(String[] args) {
         solve(new ArrayList<Integer>(Arrays.asList(1,2,3,4)), 2).forEach(System.out::println);
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> list, int B) {
        ArrayList<Integer> newList = new ArrayList<>();
        int size = list.size();

        for (int i = size - (B % size); i < size; i++) {
            newList.add(list.get(i));
        }

        for (int i =0; i< size - (B % size); i++) {
            newList.add(list.get(i));
        }

        return newList;
    }
}
