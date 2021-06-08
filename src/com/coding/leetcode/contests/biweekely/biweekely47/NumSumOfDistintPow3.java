package com.coding.leetcode.contests.biweekely.biweekely47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumSumOfDistintPow3 {

    //https://leetcode.com/contest/biweekly-contest-47/problems/check-if-number-is-a-sum-of-powers-of-three/
    public static void main( String[] args ) {
        int n = 12;
        System.out.println(checkPowersOfThree(n));

        //recursive implementation..
        System.out.println(recur(12));
    }

    private static boolean recur( int n ) {
        List<Integer> list = new ArrayList<>();
        int count = 1;

        //make the list of powers of 3 [1, 3, 9, 27,.......]
        while (count <= n) {
            if (n == count)
                return true;
            list.add(count);
            count *= 3;
        }

        return dfs(list, 0, n);
    }

    private static boolean dfs( List<Integer> list, int idx, int sum ) {
        if (sum == 0)
            return true;
        if (idx == list.size() || sum < 0)
            return false;

        boolean res;
        for (int i = idx; i < list.size(); i++) {
            res = dfs(list, i + 1, sum - list.get(i));
            if (res) return true;
        }
        return false;
    }

    private static boolean checkPowersOfThree( int n ) {
        Set<Integer> set = new HashSet<>();  // set to check that a single power is used only once.
        while (true) {
            // calculating the largest power of 3 just smaller than n in other words, 3^a < n &&  a is the greatest possible.
            int a = (int) (Math.log(n) / Math.log(3));

            if (set.contains(a))
                return false;

            set.add(a);
            n = n - (int) Math.pow(3, a);

            if (n == 0)
                return true;
        }
    }
}
