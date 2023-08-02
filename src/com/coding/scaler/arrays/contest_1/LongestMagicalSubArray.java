package com.coding.scaler.arrays.contest_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestMagicalSubArray {

    /**
     * Given Array return length of Max subarray contain only magical numbers
     *
     * Magical numbers that are divisble bt 2 or 3.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,6,5));
        //longest subarray of length is 2 = {2,6}
        System.out.println(solve(list));
    }

    private static int solve(List<Integer> list) {

        int [] temp = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)% 2 == 0 || list.get(i)% 3 == 0)
                temp[i] = 1;
            else
                temp[i] = 0;
        }

        //using carry forward tech.
        int tempAns = 0, ans = 0;
        for (int i=0; i<list.size(); i++) {
            if(temp[i] == 1) {
                tempAns++;

                ans = Math.max(ans, tempAns);
            }
            else {
                tempAns = 0;
            }
        }

        return ans;

        //Logic failed in contest :(
/*
        int [] prefix = new int[list.size()];
        prefix[0] = 0;

        for(int i=1; i<list.size(); i++) {
            if(temp[i] == 0)
                prefix[i] = 0;
            else
                prefix[i] = (i - prefix[i-1]) + 1;
        }

        int max = 0;
        for(int i=0; i<list.size(); i++) {
            max= Math.max(max, prefix[i]);
        }
*/
    }
}
