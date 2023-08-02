package com.coding.scaler.arrays.prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumQuery {

    /**
     * You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [[0, 3], [1, 2]]
     * <p>
     * Output 1:
     * [10, 5]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] q = {{1, 3}, {0, 3}};
        int[] arr = {1, 2, 3, 4, 5};
        //solveOptimal(q, arr);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,2,3,3,1,1,7,4));
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<>(Arrays.asList(1,6)));
        list.add(new ArrayList<>(Arrays.asList(5,7)));

        solve(list2, list).forEach(System.out::println);
    }

    private static void solveOptimal(int[][] q, int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        //-3+4 = 1
        //4 + 1  = 5
        //7 + 5 = 2
        //{-2, 6, -3, 4, -3}
        //-2, 4, 1, 5, 2

        for (int[] query : q) {
            int l = query[0], r = query[1];

            if (l == 0)
                System.out.println(prefixSum[r]);
            else {
                System.out.println(prefixSum[r] - prefixSum[l-1]);
            }
        }
    }

    private static List<Integer> solve(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> B) {
        List<Integer> res = new ArrayList<>();

        int n = list.size();

        int[] prefixSum = new int[n];
        prefixSum[0] = isPrime(list.get(0));

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + isPrime(list.get(i));
        }

        for (ArrayList<Integer> outer : B) {
            int l = outer.get(0), r = outer.get(1);

            if (l == 0)
                res.add(prefixSum[r]);
            else {
                res.add(prefixSum[r] - prefixSum[l-1]);
            }
        }

        return res;
    }

    public static int isPrime(int A) {
        int res = 1;

        if(A == 1)
            return 0;

        if(A == 2) {
            return 1;
        }

        if(A % 2 == 0)
            return 0;

        for(long i =3; i <= Math.sqrt(A); i+=2) {
            if(A % i == 0)
                return 0;
        }

        return res;
    }
}
