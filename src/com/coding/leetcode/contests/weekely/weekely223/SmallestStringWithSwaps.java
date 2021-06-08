package com.coding.leetcode.contests.weekely.weekely223;

import java.util.*;

public class SmallestStringWithSwaps {

    //https://leetcode.com/problems/smallest-string-with-swaps/
    public static void main( String[] args ) {
        String s = "dcab";

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list_1 = new ArrayList<>();
        list_1.add(0);
        list_1.add(3);
        lists.add(list_1);

        List<Integer> list_2 = new ArrayList<>();
        list_2.add(1);
        list_2.add(2);
        lists.add(list_2);

        System.out.println(smallestStringWithSwaps(s, lists));
    }

    //Runtime: 294 ms, faster than 7.32% of Java
    //little help: https://leetcode.com/problems/smallest-string-with-swaps/discuss/387534/Union-Find-Java-Sol
    //diagram: https://leetcode.com/problems/smallest-string-with-swaps/discuss/388257/C%2B%2B-with-picture-union-find
    private static String smallestStringWithSwaps( String s, List<List<Integer>> pairs ) {
        StringBuilder sb = new StringBuilder(s.length());

        int[] rank = new int[s.length()];
        for (int i = 0; i < rank.length; i++)
            rank[i] = i;

        for (List<Integer> list : pairs) {
            if (findParent(list.get(0), rank) != findParent(list.get(1), rank)) {
                union(list.get(0), list.get(1), rank);
            }
        }

        Map<Integer, List<Character>> graphs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int head = findParent(i, rank);
            List<Character> characters = graphs.computeIfAbsent(head, ( dummy ) -> new ArrayList<>());
            characters.add(s.charAt(i));
        }

        for (List<Character> characters : graphs.values()) {
            Collections.sort(characters);
        }

        //After sorting graph:
        //Graph[0] : "bd"
        //Graph[1] : "ac"
        //Then last task would be to find pick element from smallest to largest each group.
        for (int i = 0; i < s.length(); i++) {
            List<Character> characters = graphs.get(findParent(i, rank));
            char currentMin = characters.remove(0);
            sb.append(currentMin);
        }

        return sb.toString();
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
