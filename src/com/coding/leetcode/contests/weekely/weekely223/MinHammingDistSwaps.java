package com.coding.leetcode.contests.weekely.weekely223;

import java.util.HashMap;
import java.util.Map;

public class MinHammingDistSwaps {

    //https://leetcode.com/contest/weekly-contest-223/problems/minimize-hamming-distance-after-swap-operations/
    //similar to: SmallestStringWithSwaps
    public static void main( String[] args ) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] swaps = {
                {0, 1},
                {2, 3},
        };

        System.out.println(minimumHammingDistance(source, target, swaps));
    }

    //Runtime: 41 ms
    //Memory Usage: 78.8 MB
    private static int minimumHammingDistance( int[] source, int[] target, int[][] allowedSwaps ) {
        int[] rank = new int[source.length];
        for (int i = 0; i < rank.length; i++)
            rank[i] = i;

        for (int[] swap : allowedSwaps) {
            if (findParent(swap[0], rank) != findParent(swap[1], rank)) {
                union(swap[0], swap[1], rank);
            }
        }

        //count element for each union -find group -> key:root of each union group, value:map
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; ++i) {
            int num = source[i];
            int head = findParent(i, rank);
            Map<Integer, Integer> store = map.computeIfAbsent(head, ( dummy ) -> new HashMap<>());

            //num in place of s.charAt(i)
            store.put(num, store.getOrDefault(num, 0) + 1);
        }

        //Now we grouped each Source array element in order of swapping
        //Pending is to find its position in target array:
        // if position is empty then elements are not in order, increase the res

        int res = 0;
        for (int i = 0; i < source.length; ++i) {
            int num = target[i];
            int root = findParent(i, rank);

            Map<Integer, Integer> store = map.get(root);

            if (store.getOrDefault(num, 0) == 0) res++;
            else store.put(num, store.get(num) - 1);
        }

        return res;
    }

    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (p != rank[p]) {
            rank[p] = findParent(rank[p], rank);
        }

        return rank[p];
    }
}
