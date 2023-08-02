package com.coding.scaler.arrays.prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductArrayPuzzle {

    /**
     * Given an array of integers A, find and return the product array of the same size where the ith
     * element of the product array will be equal to the product of all the elements divided by the ith element of the array.
     * <p>
     * Note: It is always possible to form the product array with integer (32 bit) values.
     * Solve it without using the division operator.
     * <p>
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * Output 1:
     * [120, 60, 40, 30, 24]
     * <p>
     * [1, 2, 6, 24, 120]
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

        //solve(list).forEach(System.out::println);
        solveOptimal(list).forEach(System.out::println);
    }

    private static ArrayList<Integer> solve(List<Integer> list) {
        int n = list.size();
        int[] prefix = new int[n];
        prefix[0] = list.get(0);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * list.get(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(prefix[n-1] / list.get(i));
        }

        return res;
    }

    private static ArrayList<Integer> solveOptimal(List<Integer> list) {
        int n = list.size();
        int[] prefix = new int[n];
        prefix[0] = list.get(0);

        int[] sufix = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * list.get(i);
        }

        sufix[n - 1] = list.get(n - 1);
        for(int i = n - 2 ; i >= 0 ; i--){
            sufix[i] = sufix[i + 1] * list.get(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                res.add(i, sufix[i + 1]);
            }
            else if(i == n - 1){
                res.add(i, prefix[i - 1]);
            } else {
                res.add(i, prefix[i-1] * sufix[i+1]);
            }
        }

        return res;
    }
}
