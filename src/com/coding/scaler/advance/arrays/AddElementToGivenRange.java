package com.coding.scaler.advance.arrays;

import java.util.*;

public class AddElementToGivenRange {

    public static void main(String[] args) {
        int a = 5;
        int [][]b = new int[][] {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };

        //System.out.println(Arrays.toString(solve(a, b)));

        countOfStrings(new ArrayList<String>(Arrays.asList("any", "string", "here", "string")));

    }

    private static int countOfStrings(List<String> str) {
        int count  = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String item: str) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (String value: map.keySet()) {
           max = Math.max(map.get(value), max);
        }



        //str.stream().map()

        return count;
    }

    /**
     * Given Array of Size A,  having all ZEROS and Q queries. For each query add [k] for all the value of [i, j].
     * A = 5
     * B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     *
     * Output 1:-
     * 10 55 45 25 25
     *
     * After ist query:
     * [10, 10, 0, 0, 0]
     * After second query:
     * [10, 30, 20, 0, 0]
     * After third query:
     * [10, 55, 45, 25, 25]
     */
    private static int[] solve(int A, int[][] B) {

        int [] res = new int [A];
        for(int [] item : B) {
            res[item[0]- 1] += item[2];

            //bcz we have to set end item + 1 to negative val
            if(item[1] < res.length)
                res[item[1]] -= item[2];
        }

        for(int i = 1; i < res.length; i++) {
            res[i] = res[i] + res[i-1];
        }

        return res;
    }
}
