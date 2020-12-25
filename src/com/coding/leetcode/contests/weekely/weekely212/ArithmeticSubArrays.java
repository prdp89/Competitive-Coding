package com.coding.leetcode.contests.weekely.weekely212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubArrays {

    //https://leetcode.com/contest/weekly-contest-212/problems/arithmetic-subarrays/
    public static void main( String[] args ) {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};

        checkArithmeticSubarrays(nums, l, r).forEach(System.out::println);
    }

    //https://leetcode.com/problems/arithmetic-subarrays/discuss/909006/Java-Straightforward-Solution-Easy-to-Understand!
    private static List<Boolean> checkArithmeticSubarrays( int[] nums, int[] l, int[] r ) {
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int s = l[i];
            int e = r[i];

            List<Integer> temp = new ArrayList<>();
            for (int j = s; j <= e; j++) {
                temp.add(nums[j]);
            }

            res.add(checkArithmetic(temp));
        }

        return res;
    }

    private static Boolean checkArithmetic( List<Integer> temp ) {
        if (temp.size() < 2)
            return false;

        Collections.sort(temp);

        int delta = temp.get(1) - temp.get(0);
        for (int i = 0; i + 1 < temp.size(); i++) {
            if (temp.get(i + 1) - temp.get(i) != delta)
                return false;
        }

        return true;
    }
}
