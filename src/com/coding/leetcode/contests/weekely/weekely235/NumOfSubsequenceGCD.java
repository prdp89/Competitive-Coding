package com.coding.leetcode.contests.weekely.weekely235;

public class NumOfSubsequenceGCD {

    //https://leetcode.com/problems/number-of-different-subsequences-gcds/
    public static void main( String[] args ) {
        int[] nums = {6, 10, 3};
        System.out.println(countDifferentSubsequenceGCDs(nums));
    }

    // e.g. nums=[3,6,10]
    //   idx:   1,  2,  3, 4, 5,  6, 7,8,9, 10
    //[]factor: 0 , 0,  0, 0, 0,  0, 0,0,0,  0
    //  | -----------------------------------------
    //  |  3:  [3], 0, [3],0, 0,  0, 0,0,0,  0          gcd(0,3)=>3, gcd(3,3)=>3
    //  |  6:  [3],[6],[3],0 ,0, [6],0,0,0,  0          gcd(3,6)=>3, gcd(0,6)=>6, gcd(3,6)=>3,gcd(0,6)=>6
    //  | 10:  [1],[2], 3, 0,[10],6, 0,0,0,[10]
    //  | -----------------------------------------
    // \./
    //[]factor: 1,  2 , 3, 0, 10, 6, 0,0,0, 10
    //          o,  o,  o, x,  x, o, x,x,x, o   total of 5 satisfying factor[i] == i.

    //Each Index 0..20001 replaced with GCD of num[i] and at-last when GCD of 10 calculated then we'll only pick the num[i] == i

    //Runtime: 674 ms, faster than 51.74% of Java
    private static int countDifferentSubsequenceGCDs( int[] nums ) {
        int[] factor = new int[200001];

        for (int i = 0; i < nums.length; ++i) {

            // Find all factors of nums[i]
            for (int j = 1; j * j <= nums[i]; ++j) {

                if (nums[i] % j == 0) {
                    int factor1 = j;
                    int factor2 = nums[i] / j;

                    // Find gcd of all nums[i] with factor1
                    factor[factor1] = gcd(factor[factor1], nums[i]);

                    // Find gcd of all nums[i] with factor2
                    factor[factor2] = gcd(factor[factor2], nums[i]);
                }
            }
        }

        int ans = 0;

        // Check if all nums with one of factors as i form a GCD of i or not.
        for (int i = 1; i <= 200000; ++i)
            if (factor[i] == i)
                ++ans;

        return ans;
    }

    private static int gcd( int a, int b ) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
