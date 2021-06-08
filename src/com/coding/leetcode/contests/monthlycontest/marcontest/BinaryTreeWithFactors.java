package com.coding.leetcode.contests.monthlycontest.marcontest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactors {

    //https://leetcode.com/problems/binary-trees-with-factors/
    //https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/
    public static void main( String[] args ) {
        int[] arr = {2, 4};
        System.out.println(numFactoredBinaryTrees(arr));
    }

    /**
     * sort the array
     * and use HashMap to record each Integer, and the number of trees with that Integer as root
     * (1) each integer A[i] will always have one tree with only itself
     * (2) if A[i] has divisor (a) in the map, means A[i] % n == 0
     * and if A[i]/a also in the map, means map.contains(A[i] / n)
     * then (a) can be the root of its left subtree, and
     * A[i]/a can be the root of its right subtree;
     * the number of such tree is map.get(a) * map.get(A[i]/a)
     * (3) sum over the map
     */

    //Runtime: 91 ms, faster than 12.39% of Java
    private static int numFactoredBinaryTrees( int[] A ) {
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        long count = 1;

        map.put(A[0], count);

        for (int i = 1; i < A.length; i++) {
            count = 1;

            for (Integer n : map.keySet()) {
                if (A[i] % n == 0 && map.containsKey(A[i] / n)) { //step2
                    count += map.get(n) * map.get(A[i] / n);
                }
            }

            map.put(A[i], count);
        }

        long sum = 0;
        for (Integer n : map.keySet()) { //step 3
            sum = (sum + map.get(n)) % ((int) Math.pow(10, 9) + 7);
        }

        return (int) sum;
    }
}
