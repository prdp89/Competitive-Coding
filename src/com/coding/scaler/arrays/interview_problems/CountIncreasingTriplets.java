package com.coding.scaler.arrays.interview_problems;

public class CountIncreasingTriplets {

    /**
     * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
     *
     * Input 1:
     * A = [1, 2, 4, 3]
     *
     * Output 1:
     * 2
     *
     * For Input 1:
     * The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 4, 3}));
    }


    //consider each item as center and traverse let and right of it.
    //Finally, number of triplets are left * right of that items.
    private static int solve(int[] A) {

        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int Left_count = 0;
            //left traversing
            for (int j = i - 1; j >= 0; j--) {
                if ((A[j] < A[i]))
                    Left_count++;
            }

            int Right_count = 0;
            //Right traversing
            for (int j = i + 1; j < n; j++) {
                if ((A[j] > A[i]))
                    Right_count++;
            }
            count = count + (Left_count * Right_count);
        }
        return count;
    }
}
