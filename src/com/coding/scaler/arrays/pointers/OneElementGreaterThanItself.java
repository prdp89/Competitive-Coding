package com.coding.scaler.arrays.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OneElementGreaterThanItself {

    /**
     * Given an array A of N integers Unsorted. Count the number of elements that have at
     * least 1 elements greater than itself.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,1,2));

        System.out.println(solveBrute(list));
    }

    private static int solveBrute(List<Integer> list) {
        list.sort(Comparator.comparingInt(x -> x));
        int count = 0;
        for (int i=0; i<list.size(); i++) {
            for (int j=i+1; j<list.size(); j++){
                if(list.get(i) < list.get(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
