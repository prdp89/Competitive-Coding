package com.coding.scaler.hashing.advance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortArrInOrderOfB {

    public static void main(String[] args) {
        int [] A = {1, 2, 3, 4, 5, 4};
        int [] B = {5, 4, 2};
        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item : A) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int [] op = new int[A.length];
        int i=0;
        for (int item: B) {
            if(map.containsKey(item)) {
                int value = map.get(item);
                while (value-- > 0) {
                    op[i++] = item;
                }
                map.remove(item);
            }
        }

        if(!map.isEmpty()) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                while (value-- > 0) {
                    op[i++] = entry.getKey();
                }
            }
        }
        return op;
    }
}
