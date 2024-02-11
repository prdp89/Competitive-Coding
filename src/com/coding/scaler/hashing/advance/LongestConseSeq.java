package com.coding.scaler.hashing.advance;

import java.util.HashSet;
import java.util.TreeSet;

public class LongestConseSeq {

    /**
     * Given an unsorted integer array A of size N.
     *
     * Find the length of the longest set of consecutive elements from array A.
     *
     * Input 1:
     * A = [100, 4, 200, 1, 3, 2]
     *
     * Output 1:
     *  4
     *
     *  Explanation 1:
     *  The set of consecutive elements will be [1, 2, 3, 4].
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {6,4,5,2,3}));
    }

    private static int longestConsecutive(final int[] A) {
        int count = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int item: A) {
            treeSet.add(item);
        }

        int prev = -1, max = Integer.MIN_VALUE;
        for (Integer integer : treeSet) {
            int curr = integer;
            if(curr - prev == 1) {
                count++;
                max = Math.max(max, count);
            }
            else {
                count = 1;
            }

            prev = curr;

        }
        return max;
    }

    private static int longestConsecutive_method2(final int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: A) set.add(i);
        int maxCount = 0;
        for (int i=0; i<A.length; i++) {
            int count = 0;
            if (set.contains(A[i]-1))
                continue;
            else {
                int ele = A[i];
                while (set.contains(ele)) {
                    count++;
                    ele++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
