package com.coding.scaler.hashing;

import java.util.*;

public class FreEleQuery {

    /**
     * Given an array A. You have some integers given in the array B.
     * For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
     *
     * A = [1, 2, 1, 1]
     * B = [1, 2]
     *
     * Output 1:
     * [3, 1]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solve(new int[] {1, 2, 1, 1}, new int[] {1,2})
        ));

        System.out.println(
                solve2(new int[] {10, 5, 3, 4, 3, 5, 6})
        );
    }

    private static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap();

        map.get(1);

        for(int item : A) {
            int val = map.getOrDefault(item, 0) + 1;
            map.put(item, val);
        }

        int [] res = new int[B.length];
        for(int i = 0; i < B.length; i++) {
            res[i] = map.getOrDefault(B[i], 0);
        }

        return res;
    }

    private static int solve2(int [] A) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap();

        ArrayList<String> list = new ArrayList<>();
        list.sort(String::compareTo);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getValue());
        //pq.addAll(list);


        for(int item : A) {
            int val = map.getOrDefault(item, 0) + 1;
            map.put(item, val);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1;
    }


}
