package com.coding.binarysearch.arrays;

import java.util.*;

public class UniqueFractions {

    //https://binarysearch.com/problems/Unique-Fractions
    public static void main( String[] args ) {
        int[][] arr = {
                {8, 4},
                {2, 1},
                {7, 3},
                {14, 6},
                {10, 2},
                {-3, 6}
        };

        System.out.println(Arrays.deepToString(solve(arr)));
    }

    //ALmost solved it..
    //https://binarysearch.com/problems/Unique-Fractions/editorials/860242
    private static int[][] solve( int[][] fractions ) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a, b ) -> a[2] - b[2]);

        for (int[] arr : fractions) {
            int gcd = calcGCD(Math.abs(arr[0]), Math.abs(arr[1]));

            int first = arr[0] / gcd;
            int second = arr[1] / gcd;

            pq.offer(new int[]{first, second, first % second});
        }

        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();

            if (!set.contains(arr[0] + arr[1])) {
                set.add(arr[0] + arr[1]);
                list.add(new int[]{arr[0], arr[1]});
            }
        }

        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }

    private static int calcGCD( int x, int y ) {
        if (y == 0)
            return x;
        else
            return calcGCD(y, x % y);
    }
}
