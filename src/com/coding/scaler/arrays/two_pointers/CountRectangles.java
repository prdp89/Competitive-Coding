    package com.coding.scaler.arrays.two_pointers;

public class CountRectangles {

    /**
     * Given a sorted array of distinct integers A and an integer B,
     * find and return how many rectangles with distinct configurations
     * can be created using elements of this array as length and breadth whose area is lesser than B.
     *
     * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
     *
     * Input 1:
     *
     *  A = [1, 2]
     *  B = 5
     *
     *  Output 1:
     *
     *  4
     *
     *  Explanation 1:
     *
     *  All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 2}, 5));
    }

    private static int solve(int[] A, int B) {
        long count = 0;
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            long area = (long) A[left] * A[right]; // Calculate the area as a long to avoid overflow

            if (area < B) {
                count += (right - left) * 2L + 1; // All rectangles with A[left] as length are valid, add the count * 2 (for 2*3 or 3*2 combination) + 1
                left++;
            } else {
                right--; // Reduce the breadth to make the area smaller
            }
        }

        return (int)(count%1000000007);
    }
}
