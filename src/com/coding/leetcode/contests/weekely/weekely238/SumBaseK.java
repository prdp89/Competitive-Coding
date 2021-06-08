package com.coding.leetcode.contests.weekely.weekely238;

public class SumBaseK {

    //https://leetcode.com/contest/weekly-contest-238/problems/sum-of-digits-in-base-k/
    public static void main( String[] args ) {
        int m = 34, k = 6;
        System.out.println(sumBase(m, k));
    }

    private static int sumBase( int n, int k ) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            sum += n % k;
            n /= k;
        }

        //System.out.println(sb);
        return sum;
    }
}
