package com.coding.scaler.advance.maths;

public class PairSumDivisiblebyK {

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 2, 3, 4, 5}, 2));
    }

    /**
     * Given an array of integers A and an integer B, find and return the number
     * of pairs in A whose sum is divisible by B.
     *
     * Since the answer may be large, return the answer modulo (109 + 7).
     *
     * Note: Ensure to handle integer overflow when performing the calculations.
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5]
     *  B = 2
     *
     *  Output 1:
     *  4
     *
     *  Explanation 1:
     *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
     *  So total 4 pairs.
     *
     *  //Explanation from Video: https://www.youtube.com/watch?v=IUami0pKijo
     *
     *  e.g: arr = {5, 7} k = 4
     *  5 % 4 == 1 and 7 % 4 == 3, so, 3 + 1 == K (4) which means remainders sum is complementary to K (4).
     *
     *  If A % K == rem1
     *     B % K == K - rem1 (A%k) (4-1 == 3)
     *
     *     so, using count array if we have ; int rem1 = n  ` % k; then we need to find (K - rem1)
     */
    private static int solve(int[] arr, int k) {
        int[] cnt = new int[k];
        int ans = 0;
        for (int n : arr) {
            int rem = n % k;

            if(rem != 0)
                ans += cnt[k - (n % k)]; //(n % k) can be written as rem1
            else
                ans+=cnt[0]; //edge case when MOD == 0 that means we can add zero remainder directly.

            cnt[rem]++;
        }
        return ans;
    }
}
