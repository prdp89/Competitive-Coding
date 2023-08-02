package com.coding.scaler.arrays.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodPairsArr {

    /**
     * Given an array A and an integer B. A pair(i, j) in the array is a good pair
     * if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        //B = 7
        //op: 4 + 3 == B (7) exists so return 1.
        System.out.println(solveBrute(list, 7));
    }

    private static int solveBrute(List<Integer> list, int B) {
        for (int i=0; i<list.size(); i++) {
            for (int j=i+1; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == B)
                    return 1;
            }
        }

        return 0;
    }

}
