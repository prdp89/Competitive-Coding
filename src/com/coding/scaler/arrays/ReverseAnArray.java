package com.coding.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAnArray {

    /**
     * You are given a constant array A.
     *
     * You are required to return another array which is the reversed form of the input array.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        solve(list).forEach(System.out::println);
    }

    private static ArrayList<Integer> solve(final List<Integer> list) {
        int size = list.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = size - 1, j= 0; i >= 0 ; i--, j++) {
            arrayList.add(j, list.get(i));
        }
        return arrayList;
    }

}
