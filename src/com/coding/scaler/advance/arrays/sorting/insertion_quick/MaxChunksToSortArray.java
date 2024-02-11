package com.coding.scaler.advance.arrays.sorting.insertion_quick;

public class MaxChunksToSortArray {

    /**
     * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
     * if we split the array into some number of "chunks" (partitions), and individually sort each chunk.
     * After concatenating them in order of splitting, the result equals the sorted array.
     *
     * What is the most number of chunks we could have made?
     *
     * Input 1:
     *
     *  A = [2, 0, 1, 3]
     *
     *  Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     *  A = [2, 0, 1, 3]
     *  We can divide the array into 2 chunks.
     *  First chunk is [2, 0, 1] and second chunk is [3].
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {2,0,1,3}));
    }

    /**
     * For example,
     *
     * Logic below:
     *
     * original: 0, 2, 1, 4, 3, 5, 7, 6
     * max:      0, 2, 2, 4, 4, 5, 7, 7
     * sorted:   0, 1, 2, 3, 4, 5, 6, 7
     * index:    0, 1, 2, 3, 4, 5, 6, 7
     * The chunks are: 0 | 2, 1 | 4, 3 | 5 | 7, 6
     *
     * Explanation:
     * For this question, what this algorithm wants us to do is finding some splitting line
     * so that numbers being left of this line are all smaller than numbers right of this line.
     *
     * The idea is very similar to quick sort. What the answer of this question is how many lines you can find.
     * So that is why we want the max array, or we can only need a number for storing the maximum number up
     * to now(because original array is 0 to len-1), as long as the max number equals the index, we know that
     * all numbers left to this point are smaller than this point and numbers right to this point are larger
     * than this point, then we count add one.
     * @return
     */
    private static int solve(int[] A) {
        if(A == null || A.length == 0)
            return 0;

        int [] max = new int [A.length];
        max[0] = A[0];

        //just as prefix of max numbers
        for (int i=1; i<A.length; i++) {
            max[i] = Math.max(max[i-1], A[i]);
        }

        int count =0;
        for(int i=0; i<A.length; i++) {
            if(max[i] == i)
                count++;
        }

        return count;
    }
}
