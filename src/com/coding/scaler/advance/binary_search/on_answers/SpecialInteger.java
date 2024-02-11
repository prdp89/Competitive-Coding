package com.coding.scaler.advance.binary_search.on_answers;

public class SpecialInteger {


    /**
     * Given an array of integers A and an integer B,
     * find and return the maximum value K such that there is no subarray in A of size K
     * with the sum of elements greater than B.
     *
     * Input 1:
     *
     * A = [1, 2, 3, 4, 5]
     * B = 10
     *
     * Output 1:
     *
     *  2
     *
     *  Explanation 1:
     *
     * For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
     * For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
     * For K = 3, There is a subarray [3, 4, 5] which has a sum > B
     * For K = 2, There were no subarray which has a sum > B.
     * Constraints are satisfied for maximal value of 2.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( solve(new int[] {1,2,3,4,5}, 10));
    }

    private static int solve(int[] A, int B) {
        long l = 0, r = A.length, ans = 1;
        while (l <= r) {
            long m = l +  (r-l) / 2;
            if(findSubArrayOfSizeK(A, m, B)) {
                ans = m;
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return (int)ans;
    }

    //this equals to: SubArrayWithSumAndLength
    private static boolean findSubArrayOfSizeK(int [] A, long k, int B) {
        int n = A.length;

        long sum = 0;
        for (int i = 0; i < k; i++)
            sum += A[i];

        if (sum > B)
            return false;

        int start = 1, end = (int) k;
        while (end < n) {

            sum = sum - A[start - 1] + A[end];

            if (sum > B)
                return false;

            end++;
            start++;
        }

        return true;
    }
}
